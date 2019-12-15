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
        1.96,
        2.37,
        4.06,
        0.96
      },

      AZIMUTH_P = {
        0.01,//0.0035, // 0.01,
        0.017,
        0.016,
        0.015
      },
      AZIMUTH_I = {
        0.0,//0.35, // 0,
        0.1,
        0,
        0.0001
      },
      AZIMUTH_D = {
        0.00005,
        0.45,
        0.2,
        0.3
      };

    public static final PIDConstants[]
    
      AZIMUTH_CONSTANTS = {
        new PIDConstants(0.01, 0.0, 0.00005),
        new PIDConstants(/*0.017*/0.01, /*0.1*/0.0, /*0.45*/0.0),
        new PIDConstants(0.01, 0.0, 0.2),
        new PIDConstants(/*0.015*/0.01, /*0.0001*/0.0, /*0.3*/0.0)
      },

      DRIVE_CONSTANTS = {
        new PIDConstants(0.8, 0.0, 0.0),
        new PIDConstants(0.8, 0.0, 0.0),
        new PIDConstants(0.8, 0.0, 0.0),
        new PIDConstants(0.8, 0.0, 0.0)
      };

  }
}
