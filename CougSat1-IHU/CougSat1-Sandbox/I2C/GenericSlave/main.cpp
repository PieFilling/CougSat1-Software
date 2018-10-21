#include "mbed.h"
#include "rtos.h"

#include "src/GenSlavePins.h"
#include "src/GenBoardAddrs.h"
int blank()
{
    return 0;
}

int main(void)
{
    DigitalOut led1(LED1);
    led1 = 0;
    Serial usb(USBTX, USBRX);
    I2CSlave i2c(I2C0_SDA, I2C0_SCL);

    char cmd[256];
    memset(cmd, 0, 256);

    i2c.address(0x10);
    usb.printf("SLAVE 1\r\n");
    while (1)
    {
        if (i2c.receive())
        {
            usb.printf("Receiving\r\n");
            i2c.read(cmd, 256);
            // usb.printf("Read: %s\r\n", cmd);
            int count = cmd[2] - 48;
            for(int i = 0; i < count; i++){
                led1 = 1;
                wait(.5);
                led1 = 0;
                wait(.5);
            }
        }
        else
        {
            usb.printf("Not receiving\r\n");
        }
        wait(5);
    }

    return 0;
}