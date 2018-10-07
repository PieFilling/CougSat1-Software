#include <iostream>

#include "ConsoleApp.hpp"

Console::Console()
{
    
}

Console::Console(const Console &console)
{

}

Console::~Console()
{
    
}

Packet Console::requestPacket()
{

}

// Packet classes
class Packet 
{
public:
    virtual void printPacket() = 0;
    virtual void init() = 0;
    virtual void getType() = 0;
    virtual void getSize() = 0;
};

class InfoPacket : public Packet 
{
public:
    void printPacket()  {
    }

    void init(){

    }

    void getType(){

    }

    void getSize(){

    }
};

class StandardPacket : public Packet 
{
public:
    void printPacket()  {
    }

    void init(){

    }

    void getType(){

    }

    void getSize(){
        
    }
};