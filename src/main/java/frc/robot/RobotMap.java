package frc.robot;

import org.team997coders.spartanlib.helpers.PIDConstants;

//test comment
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
        4.02,
        4.71,
        1.51,
        3.15
      };

    public static final PIDConstants[]
    
      AZIMUTH_CONSTANTS = {
        new PIDConstants(0.01, 0, 0),
        new PIDConstants(0.01, 0, 0),
        new PIDConstants(0.01, 0, 0),
        new PIDConstants(0.01, 0, 0)
      },

      DRIVE_CONSTANTS = {
        new PIDConstants(0.8, 0.0, 0.0),
        new PIDConstants(0.8, 0.0, 0.0),
        new PIDConstants(0.8, 0.0, 0.0),
        new PIDConstants(0.8, 0.0, 0.0)
      };

  }
}
