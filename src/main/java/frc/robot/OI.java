package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ConveyorMove;
import frc.robot.commands.Grab;
import frc.robot.commands.SetArmAngle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public Joystick gamepad;
  private Button rightBumper, leftBumper, a, b, x, y, start;
  
  public OI(){
    
    gamepad = new Joystick(0);
    
    rightBumper = new JoystickButton(gamepad, RobotMap.Ports.rightBumper);
    leftBumper = new JoystickButton(gamepad, RobotMap.Ports.leftBumper);
    
    rightBumper.whileHeld(new ConveyorMove(RobotMap.Speeds.intakeOut));
    leftBumper.whileHeld(new ConveyorMove(RobotMap.Speeds.intakeIn));

    start = new JoystickButton(gamepad, 8);
    start.whenPressed(new Grab());

    a = new JoystickButton(gamepad, 1);
    b = new JoystickButton(gamepad, 2);
    x = new JoystickButton(gamepad, 3);
    y = new JoystickButton(gamepad, 4);
    
    a.whenPressed(new SetArmAngle(-0.01));
    b.whenPressed(new SetArmAngle(1));
    x.whenPressed(new SetArmAngle(0.5));

    y.whenPressed(new Grab());
  }

  public double getLeftYaxis() {
    return gamepad.getRawAxis(RobotMap.Ports.leftYaxis);
  }

}
