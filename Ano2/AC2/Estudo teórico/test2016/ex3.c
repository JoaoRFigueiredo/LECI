#include <detpic32.h>

char getc()
{
    if(U1STAbits.OERR == 1)
    {
        U1STAbits.OERR = 0;
    }

    while(U1STAbits.URXDA == 0);
    
    if(U1STAbits.FERR || U1STAbits.PERR )
    {
        char ch = U1RXREG;
        return 0;
    } 
    else 
    {
        return U1RXREG;
    }
}

void putc(char c)
{
    while(U1STAbits.UTXBF == 1);
    U1TXREG = c;
}

void putstr(char* c)
{
    while(*c != '\0')
    {
        putc(*c);
        c++;
    }
}

void _int_(24) isr_uart1()
{
    char command = getc();

    if(command == 'l' || command == 'L')
    {
        int swVal = PORTB & 0x0007;
        putc(swVal + '0');
    }
    else if(command == 'S' || command == 's')
    {
        putstr("Vasco Sousa");
    }
    else if (command == 'Q' || command == 'q')
    {
        exit(0);
    }

    IFS0bits.U1RXIF == 1 ? IFS0bits.U1RXIF = 0 : 1;
    IFS0bits.U1TXIF == 1 ? IFS0bits.U1TXIF = 0 : 1;
}

void configUart(int baudrate, char parity, int stopbit)
{
    U1BRG = ((PBCLK + 8 * baudrate) / (16 * baudrate)) - 1;
    U1MODEbits.BRGH = 0;

    if(parity == 'O')
    {
        U1MODEbits.PDSEL = 2;
    }
    else if (parity == 'E')
    {
        U1MODEbits.PDSEL = 1;
    }
    else
    {
        U1MODEbits.PDSEL = 0;
    }

    U1MODEbits.STSEL = stopbit - 1;

    U1STAbits.UTXEN = 1;
    U1STAbits.URXEN = 1;

    U1MODEbits.ON = 1;

    IFS0bits.U1RXIF = 0;    
    IFS0bits.U1TXIF = 0;
    IEC0bits.U1RXIE = 1;
    IEC0bits.U1TXIE = 1;
    IPC6bits.U1IP = 1;    
}

int main()
{
    EnableInterrupts();
    configUart(57600, 'O', 1);

    //Dip switches as inputs
    TRISB = (TRISB & 0xFFF8) | 0x0007;

    while(1)
    {
    }
}