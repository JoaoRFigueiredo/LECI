#include <detpic32.h>

int count = 0;

void delay(int ms)
{
    for (; ms > 0; ms--)
    {
        resetCoreTimer();
        while (readCoreTimer() < PBCLK / 1000)
            ;
    }
}

int main()
{
    //Configure leds as outputs
    TRISE = TRISE & 0xFFF0;

    //Configure switches as inputs
    TRISB = (TRISB & 0xFFF0) | 0x000F;


    while (1)
    {
        //Read led values
        int ledVal = (PORTE & 0x000F);
        if (ledVal == 0xF)
        {
            //Read value from switches
            int switchesVal = (PORTB & 0x000F);
            switchesVal ^= 0xF;

            //Write inverted switches valeu into leds
            LATE = (LATE & 0xFFF0) | switchesVal;
            count = switchesVal;
        }
        else 
        {
            count = (count << 1) | 0x0001;
            LATE = (LATE & 0xFFF0) | count;
        }
        delay(1000);
    }

    return 0;
}