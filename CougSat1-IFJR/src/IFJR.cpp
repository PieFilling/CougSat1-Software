/******************************************************************************
 * Copyright (c) 2018 by Cougs in Space - Washington State University         *
 * Cougs in Space website: cis.vcea.wsu.edu                                   *
 *                                                                            *
 * This file is a part of flight and/or ground software for Cougs in Space's  *
 * satellites. This file is proprietary and confidential.                     *
 * Unauthorized copying of this file, via any medium is strictly prohibited.  *
 ******************************************************************************/
/**
 * @file IFJR.h
 * @author Adrian Lemus
 * @date 28 Oct 2018
 * @brief Establishes in-flight reprogramming capabilities for system
 *
 * IFJR Tasks:
 *  -Returns temperature request
 *  -Return storage capacity request
 *  -Perform reprogramming of processor
 */

#include "IFJR.h"

uint8_t IFJR::init(){
    return 0;
}

uint8_t IFJR::read(uint16_t addr, uint8_t *data){
    return 0;
}

uint8_t IFJR::write(uint16_t addr, uint8_t data){
    return 0;
}

void IFJR::turnOff(){

}

void IFJR::turnOn(){

}