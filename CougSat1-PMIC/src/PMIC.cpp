/******************************************************************************
 * Copyright (c) 2018 by Cougs in Space - Washington State University         *
 * Cougs in Space website: cis.vcea.wsu.edu                                   *
 *                                                                            *
 * This file is a part of flight and/or ground software for Cougs in Space's  *
 * satellites. This file is proprietary and confidential.                     *
 * Unauthorized copying of this file, via any medium is strictly prohibited.  *
 ******************************************************************************/
/**
 * @file PMIC.h
 * @author Adrian Lemus
 * @date 21 Oct 2018
 * @brief Establishes temperature and power subsystem functionalities
 *
 * PMIC Tasks:
 *  -Return value for the desired sensor address temperature
 *  -Return value for the desired sensor address voltage
 *  -(INSERT MISSING TASKS)
 */

#include "PMIC.h"

uint8_t PMIC::init(){
    return 0;
}

// these functions read and write from proper addresses in hardware
uint8_t PMIC::read(uint16_t addr, uint8_t *data){
    return 0;
}

uint8_t PMIC::write(uint16_t addr, uint8_t data){
    return 0;
}

void PMIC::turnOff(){

}

void PMIC::turnOn(){

}