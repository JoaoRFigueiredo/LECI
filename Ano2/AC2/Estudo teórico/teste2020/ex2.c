#include <detpic32.h>
#define SAMPLES_NUM 4 

short displayFlag = 0;
int average = 0;
int digits[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};

void _int_(8) isr_timer2()
{
    if(displayFlag)
    {
        int high = average / 10;
        LATDbits.LATD5 = 1;
        LATDbits.LATD6 = 0;
        LATB = (LATB & 0x00FF) | (digits[high] << 8);
        printInt10(digits[high]);
    }
    else
    {
        int low = average % 10;
        LATDbits.LATD5 = 0;
        LATDbits.LATD6 = 1;
        LATB = (LATB & 0x00FF) | (digits[low] << 8);
        printInt10((digits[low]));
        putChar('\n');
    }
    displayFlag = !displayFlag;
    IFS0bits.T2IF = 0;
}

void _int_(27) isr_adc1()
{
    AD1CON1bits.ASAM = 1;  
    
    int* values = (int*) &ADC1BUF0;  // [S1, S2, S3, S4]
    int total = 0;
    
    int i = 0;

    for( i = 0; i < SAMPLES_NUM; i++)
    {
        total += values[i * 4];  //int size is 4 bytes
    }

    average = total / SAMPLES_NUM; 
    average = average * 33 / 1023;
    IFS1bits.AD1IF = 0;
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

    IFS1bits.AD1IF = 1;
    IEC1bits.AD1IE = 1;
    IPC6bits.AD1IP = 1;

}

void configTimer2()
{
    T2CONbits.TCKPS = 2; //1 2 4 8 16 32 64 254
    PR2 = 50000 - 1;
    TMR2 = 0; 
    T2CONbits.TON = 1;

    IFS0bits.T2IF = 1;
    IEC0bits.T2IE = 1;
    IPC2bits.T2IP = 2;
}

void configDisplay()
{
    TRISDbits.TRISD5 = 0;
    TRISDbits.TRISD6 = 0;

    TRISB = (TRISB & 0x00FF); 
}

int main()
{
    EnableInterrupts();
    configTimer2();
    configAdc();
    configDisplay();

    while(1);
}