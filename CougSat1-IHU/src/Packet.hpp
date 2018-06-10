#pragma once

class Packet
{
    public:
        Packet();
        Packet(const Packet &packet);
        ~Packet();
    private:
    bool isReady;
};
