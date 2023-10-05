#include <detpic32.h>
int digits[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};

int main()
{
    //Leds as outputs
    TRISE = (TRISE & 0xFFF0); 
    
    //Switches as inputs
    TRISB = (TRISB & 0xFFF0) | 0x000F;

    //Displays as outputs
    TRISB = (TRISB & 0x00FF);   
    TRISD = (TRISD & 0xFF9F);

    //Toggle high display
    LATD = (LATD & 0xFF9F) | 0x0020;

    while(1)
    {
        int swVal = PORTB & 0x000F;
        LATE = (LATE & 0xFFF0) | swVal;

        LATB = (LATB & 0x00FF) | (digits[swVal] << 8);
    }

    return 0;
}