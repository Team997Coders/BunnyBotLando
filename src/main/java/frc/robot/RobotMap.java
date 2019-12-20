package frc.robot;

import org.team997coders.spartanlib.helpers.PIDConstants;

//test comment
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  public static class Speeds {
    public static final double
      intakeIn = 0.5,
      intakeOut = -0.5;
  }
  public static class Values{
    public static final double 
      armBucketUpEncoderTicks = 7654.321, //TODO: Make this eqal something rea
      armMinEncoderTicks = -1265.5,
      armMaxEncoderTicks = 0,

      armP = 3;

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
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public final static class Ports {
    public final static int
    armMotor = 9, //Get real port
    joystick = 0, //Get real port
    leftYaxis = 1,
    grabberSolenoidPort1 = 1, //TODO: Get real port
    grabberSolenoidPort2 = 0, //TODO: Get real port
    beltyBoi = 42069, //TODO: reeeee at Emi for acutal port
    rightBumper = 5,
    leftBumper = 4;

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
}
