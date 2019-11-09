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

    public static final double[]

      MODULE_FORWARD = {
        4.67,
        2.31,
        1.63,
        3.15
      },

      AZIMUTH_P = {
        0.00,
        0.00,
        0.00,
        0.01
      },
      AZIMUTH_I = {
        0,
        0,
        0,
        0
      },
      AZIMUTH_D = {
        0.00000,
        0.00000,
        0.00000,
        0.00005
      };

  }
}
