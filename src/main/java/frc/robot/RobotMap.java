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
    public static final double
      intakeIn = 0.5,
      intakeOut = -0.5;
  }

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public final static class Ports {
    public final static int
    armMotor = 0, //Get real port
    joystick = 0, //Get real port
    leftYaxis = 1,
    grabberSolenoidPort1 = 0, //TODO: Get real port
    grabberSolenoidPort2 = 0, //TODO: Get real port
    beltyBoi = 42069, //TODO: reeeee at Emi for acutal port
    rightBumper = 5,
    leftBumper = 4;
  }
}
