package frc.robot;

import org.team997coders.spartanlib.helpers.PIDConstants;

//test comment
public class RobotMap {

  public static class Speeds {
    public static final double intakeIn = 1, intakeOut = -1;
  }

  public static class Ports {

    public static final int[]

    AZIMUTH = { 1, 3, 5, 7 },

        DRIVE = { 2, 4, 6, 8 };

    public final static int armMotor = 9, // Get real port
        joystick = 0, // Get real port
        leftYaxis = 1, leftXaxis = 0, rightYaxis = 5, rightXaxis = 4, grabberSolenoidPort1 = 1, // TODO: Get real port
        grabberSolenoidPort2 = 0, // TODO: Get real port
        beltyBoi = 10, // TODO: reeeee at Emi for acutal port
        rightBumper = 5, leftBumper = 6;

  }

  public static class Values {
    public static final double armMinEncoderTicks = -1265.5, armMaxEncoderTicks = 0,

        armP = 3, ticksPerRev = 261.3, ticksPerInch = 20.79625, ticksPerFoot = 12 * ticksPerInch, armTolerance = 0.01,
        armUp = 1, armBucket = 0, armBunny = -0.05;

    public static final double[]

    MODULE_FORWARD = { 4.02, 4.71, 1.51, 3.15 };

    public static final PIDConstants[]

    AZIMUTH_CONSTANTS = { new PIDConstants(0.01, 0, 0), new PIDConstants(0.01, 0, 0), new PIDConstants(0.01, 0, 0),
        new PIDConstants(0.01, 0, 0) },

        DRIVE_CONSTANTS = { new PIDConstants(0.8, 0.0, 0.0), new PIDConstants(0.8, 0.0, 0.0),
            new PIDConstants(0.8, 0.0, 0.0), new PIDConstants(0.8, 0.0, 0.0) };

    public static final PIDConstants AUTO_DRIVE_PID = new PIDConstants(0.01, 0.0, 0.0),
        AUTO_TURN_PID = new PIDConstants(0.01, 0.0, 0.0);

  }

  public static class FieldValues {

    public static final double

      STATION_TO_BUCKET_TOUCH = 25, STATION_TO_BUCKET_GRAB = 23.9;

  }

}
