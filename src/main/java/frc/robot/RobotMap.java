package frc.robot;

import org.team997coders.spartanlib.helpers.PIDConstants;

//test comment
public class RobotMap {

  public static class Ports {

    public static final int

      ARM_TALON = 666,
      INTAKE_VICTOR = 666,
      GRABBER_SOLENOID_A = 0,
      GRABBER_SOLENOID_B = 1,

      GAMEPAD_1 = 0,
      GAMEPAD_2 = 1;

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
    
      // Despite the fact that they are named up and down, up is sorta up and down is to the side and down
      ARM_UP = 0.0,
      ARM_DOWN = 0.0,
      ARM_DEGREES_RANGE = 110,

      LIMELIGHT_HORZ_FOV = 54,

      MODULE_TICKS_IN_FOOT = 12000, // Complete BS

      VISION_TARGET_AREA_PICKUP = 10; // Target area when in range of pickup

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

    public static final PIDConstants

      ROTATION_CORRECTION_CONSTANTS =
        new PIDConstants(1.0, 0.0, 0.0),
      
      DRIVE_FEET_CONSTANTS =
        new PIDConstants(1.0, 0.0, 0.0),

      STRAFE_CORRECTION_CONSTANTS =
        new PIDConstants(1.0, 0.0, 0.0),

      DRIVE_TARGET_CONSTANTS =
        new PIDConstants(1.0, 0.0, 0.0),

      STRAFE_TARGET_CONSTANTS =
        new PIDConstants(1.0, 0.0, 0.0);

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

  public static class FieldValues {

    public static final double

      STATION_TO_BUCKET_TOUCH = 25,
      STATION_TO_BUCKET_GRAB = 23.9;

  }

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  public static class Preferences {

    public static final double

      INTAKE_SPEED_IN = 0.5,
      INTAKE_SPEED_OUT = -0.5,
      INTAKE_SPEED_AUTO_IN = 0.4,
      INTAKE_SPEED_AUTO_OUT = -0.5,
      ARM_SPEED_MAX = 0.3,

      AUTO_DRIVE_SPEED_PERCISE = 0.2,
      AUTO_DRIVE_SPEED = 0.5,
      AUTO_ROTATE_SPEED_PERCISE = 0.1,
      AUTO_ROTATE_SPEED = 0.7;
  }
}
