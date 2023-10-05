#include <detpic32.h>
#define SAMPLES_NUM 1

int digits[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
int curTemp = 0;
short displayFlag = 0;
volatile int curTime = 0;

void _int_(8) isr_timer2()
{
    if(readCoreTimer() >= PBCLK / 1000) 
    {
        curTime = readCoreTimer();
        resetCoreTimer();
    }

    int high = curTemp / 10;
    int low = curTemp % 10;

    if(displayFlag)
    {
        LATDbits.LATD5 = 1;
        LATDbits.LATD6 = 0;
        LATB = (LATB & 0x00FF) | (digits[high] << 8);
    }
    else
    {
        LATDbits.LATD5 = 0;
        LATDbits.LATD6 = 1;
        LATB = (LATB & 0x00FF) | (digits[low] << 8);
    }

    displayFlag = !displayFlag;

    IFS0bits.T2IF = 0;
}

void _int_(10) isr_osc2()
{
    printInt10(curTime);
    putChar('\n');
    curTime = 0;
}

void configAdc()
{
    TRISBbits.TRISB4 = 1;
    AD1PCFGbits.PCFG4 = 0; 
    AD1CON1bits.SSRC = 7;
    AD1CON1bits.CLRASAM = 1;
    AD1CON3bits.SAMC = 16; 
    AD1CON2bits.SMPI = SAMPLES_NUM-1;
    AD1CHSbits.CH0SA = 4; 
    AD1CON1bits.ON = 1;

    /*IFS1bits.AD1IF = 1;
    IEC1bits.AD1IE = 1;
    IPC6bits.AD1IP = 1;*/
}

void configOC2()
{
    OC2CONbits.OCM = 6;
    OC2CONbits.OCTSEL = 0;
    OC2RS = (49999 + 1) * 0.25;
    OC2CONbits.ON = 1;

    IFS0bits.OC2IF = 1;
    IEC0bits.OC2IE = 1;
    IPC2bits.OC2IP = 1;
}

void configTimer2()
{
    TMR2 = 0; 
    T2CONbits.TCKPS =   0; // fout = (PBCLK / K) / PR2 (=) K = 20000000/(65535*400)
    PR2 = 49999;
    T2CONbits.ON = 1;

    IEC0bits.T2IE = 1;
    IPC2bits.T2IP = 2;
    IFS0bits.T2IF = 1;
}

int main()
{
    EnableInterrupts();
    configAdc();
    configTimer2();

    //Config displays
    TRISB = (TRISB & 0x00FF);
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;

    while(1)
    {
        AD1CON1bits.ASAM = 1;
        while(IFS1bits.AD1IF == 0);
        int voltage = ADC1BUF0;
        curTemp =  (voltage * 70+511)/1023;
        printInt10(curTemp);
        putChar('\n');
        IFS1bits.AD1IF = 0;
    }
}
