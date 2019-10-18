/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static class Ports {

    public static final int

      azimuth0 = 1,
      azimuth1 = 3,
      azimuth2 = 5,
      azimuth3 = 7,

      drive0 = 2,
      drive1 = 4,
      drive2 = 6,
      drive3 = 8;

  }

  public static class Values {

    public static final double

      moduleForward0 = 1.07788, // Redo
      moduleForward1 = 0,
      moduleForward2 = 0,
      moduleForward3 = 0,

      azimuthP = 0.001,
      azimuthI = 0.0,
      azimuthD = 0.00005;

  }
}
