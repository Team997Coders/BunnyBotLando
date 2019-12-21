package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ConveyorMove;
import frc.robot.commands.Failsafe;
import frc.robot.commands.Grab;
import frc.robot.commands.SetArmAngle;
import frc.robot.commands.drive.ZeroSwerve;
import frc.robot.util.JoystickDPad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public Joystick gamepad1, gamepad2;
  private JoystickButton rightBumper, leftBumper, a, b, x, y;
  private JoystickDPad up, down, left;
  
  public OI(){
    
    gamepad1 = new Joystick(0);

    up = new JoystickDPad(gamepad2, 0);
    down = new JoystickDPad(gamepad2, 180);
    left = new JoystickDPad(gamepad2, 270);
    
    rightBumper = new JoystickButton(gamepad2, RobotMap.Ports.rightBumper);
    leftBumper = new JoystickButton(gamepad2, RobotMap.Ports.leftBumper);

    a = new JoystickButton(gamepad2, 1);
    b = new JoystickButton(gamepad2, 2);
    x = new JoystickButton(gamepad2, 3);
    y = new JoystickButton(gamepad1, 4);
    
    a.whenPressed(new Grab(true));
    b.whenPressed(new Failsafe());
    x.whenPressed(new Grab(false));
    y.whenPressed(new ZeroSwerve());

    up.whenPressed(new SetArmAngle(RobotMap.Values.armUp));
    down.whenPressed(new SetArmAngle(RobotMap.Values.armBunny));
    left.whenPressed(new SetArmAngle(RobotMap.Values.armBucket));
  }

  public double getAxis1(int port) {
    return gamepad1.getRawAxis(port);
  }

  public double getAxis2(int port) {
    return gamepad2.getRawAxis(port);
  }

}
