/******************************************************************************
 * Copyright (c) 2018 by Cougs in Space - Washington State University         *
 * Cougs in Space website: cis.vcea.wsu.edu                                   *
 *                                                                            *
 * This file is a part of flight and/or ground software for Cougs in Space's  *
 * satellites. This file is proprietary and confidential.                     *
 * Unauthorized copying of this file, via any medium is strictly prohibited.  *
 ******************************************************************************/
/**
 * @file main.cpp
 * @author Bradley Davis
 * @date 6 Mar 2018
 * @brief Starts the IHU software
 *
 * Initializes IHU object and starts the eventQueue
 */

#include <mbed.h>
#include <rtos.h>
#include "IHU.h"
#include "tools/CISError.h"

/**
 * Program start routine
 * Initializes IHU object and starts the eventQueue
 * @return error code
 */
int main(void) {
  Serial usb(USBTX, USBRX);
  usb.printf("Test\r\n");
  IHU* ihu = IHU::getInstance();
  usb.printf("Test2\r\n");
  ihu->initialize();
  usb.printf("Test3\r\n");
  ihu->run();
  return ERROR_SUCCESS;
}
