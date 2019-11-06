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

      AZIMUTH_0 = 1,
      AZIMUTH_1 = 3,
      AZIMUTH_2 = 5,
      AZIMUTH_3 = 7,

      DRIVE_0 = 2,
      DRIVE_1 = 4,
      DRIVE_2 = 6,
      DRIVE_3 = 8;

  }

  public static class Values {

    public static final double

      MODULE_FORWARD_0 = 0.56,
      MODULE_FORWARD_1 = 1.66,
      MODULE_FORWARD_2 = 0,
      MODULE_FORWARD_3 = 0,

      AZIMUTH_P = 0.01, // 0.001,
      AZIMUTH_I = 0.0,
      AZIMUTH_D = 0.00005;

  }
}
