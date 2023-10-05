#include <detpic32.h>
#define BUF_SIZE 8
#define MASK 7

typedef struct 
{      
    unsigned char data[BUF_SIZE];    
    unsigned int head;       
    unsigned int tail;    
    unsigned int count;    
} 
circularBuffer;

volatile circularBuffer txb;
volatile circularBuffer rxb;

void _int_(24) isr_uart1()
{
    if(IFS0bits.U1RXIF == 1)
    {
        if(rxb.count < BUF_SIZE)
        {
            rxb.data[rxb.tail] = U1RXREG;
            rxb.tail = (rxb.tail + 1) & MASK;
            rxb.count++;
        }
        if(rxb.count == BUF_SIZE)
        {
            IEC0bits.U1RXIE = 0;
        }
        IFS0bits.U1RXIF = 0;
    }
    else
    {
        if(txb.count > 0)
        {
            U1TXREG = txb.data[txb.head];
            txb.head = (txb.head + 1) & MASK;
            txb.count--;
        }
        
        if (txb.count == 0)
        {
            IEC0bits.U1TXIE = 0;
        }
        IFS0bits.U1TXIF = 0;
    }
}

void putc(char c)
{
    while(txb.count == BUF_SIZE);

    txb.data[txb.tail] = c;
    txb.tail = (txb.tail + 1) & MASK;
    IEC0bits.U1TXIE = 0;
    txb.count++;
    IEC0bits.U1TXIE = 1;
}

void putstr(char* str)
{
    while(*str != '\0')
    {
        putc(*str);
        str++;
    }
}

char getc()
{
    while(rxb.count == 0);
    char c = rxb.data[rxb.head];
    IEC0bits.U1TXIE = 0;
    rxb.head = (rxb.head + 1) & MASK;
    rxb.count--;
    IEC0bits.U1TXIE = 1;

    return c;
}

void flushBuffers()
{
    rxb.head = 0;
    rxb.tail = 0;
    rxb.count = 0;
    txb.head = 0;
    txb.tail = 0;
    txb.count = 0;
}

void configUart(int baudrate, char paraty, int stopbit)
{
    U1BRG = ((PBCLK + 8 * baudrate) / (16* baudrate)) - 1;
    U1MODEbits.BRGH = 0;
    
    if(stopbit == 1)
    {
        U1MODEbits.STSEL = 0;
    }
    else 
    {
        U1MODEbits.STSEL = 1;
    }

    if(paraty == 'N' || paraty== 'n')
    {
        U1MODEbits.PDSEL = 0;
    }
    else if (paraty == 'E' || paraty == 'e')
    {
        U1MODEbits.PDSEL = 1;
    }
    else 
    {
        U1MODEbits.PDSEL = 2;
    }

    U1STAbits.URXEN = 1;
    U1STAbits.UTXEN = 1;
    U1MODEbits.ON = 1;
    
    IFS0bits.U1RXIF = 0;
    IFS0bits.U1TXIF = 0;
    IPC6bits.U1IP = 1;
    IEC0bits.U1RXIE = 1;
    IEC0bits.U1TXIE = 1;
}

int main()
{
    flushBuffers();
    EnableInterrupts();
    configUart(9600, 'E', 1);

    int lowercaseNum = 0;
    while(1)
    {
        char c = getc();

        if(c != '\n')
        {
            putc(c);
            if(c >= 'a' && c <= 'z')
            {
                lowercaseNum++;
            }
        }
        else
        {
            putc('\n');
            putstr("O número de letras maíusculas é ");
            putc(lowercaseNum + '0');
            putc('\n');
            lowercaseNum = 0;
        }
    }

    return 0;
}