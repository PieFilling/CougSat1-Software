/******************************************************************************
 * Copyright (c) 2018 by Cougs in Space - Washington State University         *
 * Cougs in Space website: cis.vcea.wsu.edu                                   *
 *                                                                            *
 * This file is a part of flight and/or ground software for Cougs in Space's  *
 * satellites. This file is proprietary and confidential.                     *
 * Unauthorized copying of this file, via any medium is strictly prohibited.  *
 ******************************************************************************/
/**
 * @file PMIC.cpp
 * @author Bradley Davis
 * @date 6 Mar 2018
 * @brief Communicates betwen the IHU and the PMIC
 */

#include "PMIC.h"
#include "tools/CISError.h"

/**
 * Constructs PMIC object
 * Saves a reference to the i2c
 * @param i2c connected to PMIC
 */
PMIC::PMIC(I2C &i2c) :
    i2c(i2c) {
    
}

/**
 * Destructor is currently empty
 */
PMIC::~PMIC() {

}

/**
 * Initializes interface to PMIC
 * @return error code
 */
uint8_t PMIC::initialize() {
  DEBUG("PMIC", "Starting initialization");
  CONSOLE_TX("PMIC", "Starting initialization");
  uint8_t result = 
  if (result != ERROR_SUCCESS) {
    DEBUG("PMIC", "PMIC ping error: 0x%02x", result);
    CONSOLE_TX("PMIC", "PMIC ping error: 0x%02x", result);
    return result;
  }

  DEBUG("PMIC", "Initialization complete");
  CONSOLE_TX("PMIC", "Initialization complete");
  return ERROR_SUCCESS;
}
