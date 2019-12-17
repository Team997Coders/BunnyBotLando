package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ConveyorMove;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public Joystick gamepad;
  private Button rightBumper, leftBumper;
  
  public OI(){
    
    gamepad = new Joystick(0);
    
    rightBumper = new JoystickButton(gamepad, RobotMap.Ports.rightBumper);
    leftBumper = new JoystickButton(gamepad, RobotMap.Ports.leftBumper);
    
    rightBumper.whileHeld(new ConveyorMove(RobotMap.Speeds.intakeOut));
    leftBumper.whileHeld(new ConveyorMove(RobotMap.Speeds.intakeIn));

   
  }

  public double getLeftYaxis() {
    return gamepad.getRawAxis(RobotMap.Ports.leftYaxis);
  }

}
