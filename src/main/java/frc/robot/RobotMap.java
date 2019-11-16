package frc.robot;

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
        4.68,
        3.03,
        3.63,
        3.17
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

  }
}
