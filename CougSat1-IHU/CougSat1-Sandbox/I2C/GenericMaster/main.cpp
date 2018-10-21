#include "mbed.h"
#include "rtos.h"

#include "src/GenMasterPins.h"
#include "src/GenBoardAddrs.h"

int main(void)
{
    Serial usb(USBTX, USBRX);
    I2C i2c(I2C0_SDA, I2C0_SCL);
    int addr;
    char cmd[256];
    usb.printf("MASTER:\r\n");
    while (1)
    {
        memset(cmd, 0, 256);
        usb.printf("Get command from ground\r\nCMD: ");
        usb.gets(cmd, 256);
        if(cmd[0] == 1 + 48){
            addr = 0x10;
        }
        else{
            addr = 0x20;
        }
        usb.printf("Writing to subsystem %d\r\n", cmd[0]-48);
        i2c.write(addr, cmd, 256);
        wait(2);
    }

    return 0;
}