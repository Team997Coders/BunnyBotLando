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
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  public static class Speeds {
    public static final double intakeIn = 0.5, intakeOut = -0.5;
  }

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public final static class Ports {
    public final static int armMotor = 9, // Get real port
        joystick = 0, // Get real port
        leftYaxis = 1, grabberSolenoidPort1 = 0, // TODO: Get real port
        grabberSolenoidPort2 = 1, // TODO: Get real port
        beltyBoi = 42069, // TODO: reeeee at Emi for acutal port
        rightBumper = 5, leftBumper = 4;
  }

  public final static class ArmConstants {
    /**
     * Which PID slot to pull gains from. Starting 2018, you can choose from 0,1,2
     * or 3. Only the first two (0,1) are visible in web-based configuration.
     */
    public static final int kSlotIdx = 0;

    /**
     * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For now
     * we just want the primary one.
     */
    public static final int kPIDLoopIdx = 0;

    /**
     * set to zero to skip waiting for confirmation, set to nonzero to wait and
     * report to DS if action fails.
     */
    public static final int kTimeoutMs = 30;

    /**
     * Gains used in Motion Magic, to be adjusted accordingly Gains(kp, ki, kd, kf,
     * izone, peak output);
     */
    public static final double kP = 0.2;
    public static final double kI = 0.0;
    public static final double kD = 0.0;
    public static final double kF = 0.0;
    public static final int kIZone = 0;
    public static final double kPeakOutput = 1.0;
  }
}
