#pragma once

class PacketTable
{
    public:
        PacketTable();
        PacketTable(const PacketTable &packetTable);
        ~PacketTable();
    public:        
        bool getIsFull() const {return isFull;}
        
        void setIsFull(const bool val) {isFull = val;}

    private:
    bool isFull;
};