/******************************************************************************
 * Copyright (c) 2018 by Cougs in Space - Washington State University         *
 * Cougs in Space website: cis.vcea.wsu.edu                                   *
 *                                                                            *
 * This file is a part of flight and/or ground software for Cougs in Space's  *
 * satellites. This file is proprietary and confidential.                     *
 * Unauthorized copying of this file, via any medium is strictly prohibited.  *
 ******************************************************************************/
/**
 * @file ADCS.h
 * @author Adrian Lemus
 * @date 28 Oct 2018
 * @brief (INSERT DESCRIPTION)
 *
 * ADCS Tasks:
 *  -
 */

#ifndef SRC_ADCS_H_
#define SRC_ADCS_H_

#include <mbed.h>
#include <CougSat1-IHU/src/systemInterfaces/SubsystemAbstractClass.h>

class ADCS : public SubsystemAbstractClass {
  public:

    uint8_t init();

    // these functions read and write from proper addresses in hardware
    uint8_t read(uint16_t addr, uint8_t *data);
    uint8_t write(uint16_t addr, uint8_t data);

    void turnOff();
    void turnOn();

  private:
};

#endif /* !SRC_ADCS_H_ */