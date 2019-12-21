package frc.robot;

import org.team997coders.spartanlib.helpers.PIDConstants;

//test comment
public class RobotMap {

  public static class Speeds {
    public static final double
      intakeIn = 0.5,
      intakeOut = -0.5;
  }

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

      public final static int
        armMotor = 9, //Get real port
        joystick = 0, //Get real port
        leftYaxis = 1,
        leftXaxis = 0,
        rightYaxis = 5,
        rightXaxis = 4,
        grabberSolenoidPort1 = 0, //TODO: Get real port
        grabberSolenoidPort2 = 0, //TODO: Get real port
        beltyBoi = 42069, //TODO: reeeee at Emi for acutal port
        rightBumper = 5,
        leftBumper = 4;
  }

  public static class Values {

    public static final double
      ticksPerRev = 261.3,
      ticksPerInch = 20.79625,
      ticksPerFoot = 12 * ticksPerInch;

    public static final double 
      armGroundHeight = 202818024, //TODO: make this a real value, the height we need to be at to pick up a bucket.
      armMaxEncoderTicks = 45678,
      armMinEncoderTicks = 123,
      armTolerance = 5;

    public static final double[]

      MODULE_FORWARD = {
        1.96,
        2.37,
        4.06,
        0.96
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

      public static final PIDConstants
      AUTO_DRIVE_PID = new PIDConstants(0.01, 0.0, 0.0),
      AUTO_TURN_PID = new PIDConstants(0.01, 0.0, 0.0);

  }
}
