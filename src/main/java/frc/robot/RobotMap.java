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

    public static final int[]

      AZIMUTH = {
        1,
        3,
        5,
        7
      },

      DRIVE = {
        2,
        4,
        6,
        8
      };

  }

  public static class Values {

    public static final double
      VISION_TOLERANCE = 0.03, //tolerance for vision target commands
      VISION_TARGET_SIZE = 1.0,
      VISION_P = 1.5; //larger than normal P-values since vison's error will be at maximum 1.

    public static final double[]

      MODULE_FORWARD = {
        4.68,
        3.03,
        4.10,
        3.17
      },

      AZIMUTH_P = {
        0.01,
        0.01,
        0.01,
        0.02
      },
      AZIMUTH_I = {
        0,
        0,
        0,
        0
      },
      AZIMUTH_D = {
        0.00005,
        0.00005,
        0.00005,
        0.00005
      };

  }
}
