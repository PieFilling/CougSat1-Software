/******************************************************************************
 * Copyright (c) 2018 by Cougs in Space - Washington State University         *
 * Cougs in Space website: cis.vcea.wsu.edu                                   *
 *                                                                            *
 * This file is a part of flight and/or ground software for Cougs in Space's  *
 * satellites. This file is proprietary and confidential.                     *
 * Unauthorized copying of this file, via any medium is strictly prohibited.  *
 ******************************************************************************/
/**
 * @file SubSystem.h
 * @author Adrian Lemus
 * @date 21 Oct 2018
 * @brief Abstract class for subsystem classes
 *
 * Contains standard methods for all subsystem classes to
 * implement
 */
#ifndef SRC_SUBSYSTEMABSTRACTCLASS_SUBSYSTEMABSTRACTCLASS_H_
#define SRC_SUBSYSTEMABSTRACTCLASS_SUBSYSTEMABSTRACTCLASS_H_

#include <mbed.h>

class SubsystemAbstractClass {
  public:
    virtual uint8_t init() = 0;

    virtual uint8_t read(uint16_t addr, uint8_t *data) = 0;
    virtual uint8_t write(uint16_t addr, uint8_t data) = 0;

    virtual void turnOff() = 0;
    virtual void turnOn() = 0;
};

#endif /* SRC_SUBSYSTEMABSTRACTCLASS_SUBSYSTEMABSTRACTCLASS_H_ */
