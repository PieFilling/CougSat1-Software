/******************************************************************************
 * Copyright (c) 2018 by Cougs in Space - Washington State University         *
 * Cougs in Space website: cis.vcea.wsu.edu                                   *
 *                                                                            *
 * This file is a part of flight and/or ground software for Cougs in Space's  *
 * satellites. This file is proprietary and confidential.                     *
 * Unauthorized copying of this file, via any medium is strictly prohibited.  *
 ******************************************************************************/
/**
 * @file CISConsole.h
 * @author Bradley Davis
 * @date 6 Mar 2018
 * @brief Communicates between the IHU and the testing computer
 *
 * For use during testing via the umbilical
 * SWO is for debug printing
 * USART is for message printing and recieving
 */

#ifndef SRC_TOOLS_CISCONSOLE_H_
#define SRC_TOOLS_CISCONSOLE_H_

#include "mbed.h"
#include "SWO.h"
#include "IHU.h"

//#define NDEBUG

extern SWO_Channel swo;
extern Serial umbilical;

/**
 * Prints to the SWO port as follows:
 * "[time stamp] object name: message"
 * @param o name of class or function
 * @param args... standard printf arguments
 */
#ifndef NDEBUG
#define DEBUG(o, args...) {swo.printf("[%07lu] %10s: ", HAL_GetTick(), o); swo.printf(args); swo.putc('\n');}
#else
#define DEBUG(o, ...) {}
#endif

/**
 * Prints to the umbilical USART port as follows:
 * "[time stamp] object name: message"
 * @param o name of the class or function
 * @param args... standard printf arguments
 */
#define CONSOLE_TX(o, args...) {umbilical.printf("[%7lu] %10s: ", HAL_GetTick(), o); umbilical.printf(args); umbilical.putc('\n');}

/**
 * Clears the console's screen
 */
#define CONSOLE_CLR {umbilical.putc(27); umbilical.printf("[2J"); umbilical.putc(27); umbilical.printf("[H");}

#endif /* SRC_TOOLS_CISCONSOLE_H_ */
