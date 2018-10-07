#pragma once

class Console
{
    public:
        Console();
        Console(const Console &console);
        ~Console();
    public:
        bool getIsRunning() const { return isRunning; }

        void setIsRunning(const bool val) { isRunning = val; }

        Packet requestPacket();
    
    private:
        bool isRunning;
};
