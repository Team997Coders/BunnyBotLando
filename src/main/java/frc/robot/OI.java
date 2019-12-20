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

  public Joystick gamepad1, gamepad2;
  private Button rightBumper, leftBumper, a, b, x, y;
  
  public OI(){
    
    gamepad1 = new Joystick(0);
    
    rightBumper = new JoystickButton(gamepad1, RobotMap.Ports.rightBumper);
    leftBumper = new JoystickButton(gamepad1, RobotMap.Ports.leftBumper);
    
    rightBumper.whileHeld(new ConveyorMove(RobotMap.Speeds.intakeOut));
    leftBumper.whileHeld(new ConveyorMove(RobotMap.Speeds.intakeIn));

    a = new JoystickButton(gamepad1, 1);
    b = new JoystickButton(gamepad1, 2);
    x = new JoystickButton(gamepad1, 3);
    y = new JoystickButton(gamepad1, 4);
    
    a.whenPressed(new SetArmAngle(-0.01));
    b.whenPressed(new SetArmAngle(1));
    x.whenPressed(new SetArmAngle(0.5));

    y.whenPressed(new Grab());
  }

  public double getAxis(int port) {
    return gamepad1.getRawAxis(port);
  }

}
