package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.drive.SetModuleAngle;
import frc.robot.commands.drive.ZeroSwerve;
import org.team997coders.spartanlib.math.MathUtils;
import frc.robot.commands.ConveyorMove;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {


  public Joystick gamepad0, gamepad1;
  private JoystickButton mA0, mB0, mX0, mY0, mRB1, mLB1;
  
  public OI(){
    
    gamepad0 = new Joystick(0);
    gamepad1 = new Joystick(1);

    mRB1 = new JoystickButton(gamepad0, RobotMap.Ports.rightBumper);
    mLB1 = new JoystickButton(gamepad0, RobotMap.Ports.leftBumper);
    
    mRB1.whileHeld(new ConveyorMove(RobotMap.Speeds.intakeOut));
    mLB1.whileHeld(new ConveyorMove(RobotMap.Speeds.intakeIn));

    mA0 = new JoystickButton(gamepad0, 1);
    mB0 = new JoystickButton(gamepad0, 2);
    mX0 = new JoystickButton(gamepad0, 3);
    mY0 = new JoystickButton(gamepad0, 4);

    if (Robot.IS_TUNING) {
      mA0.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 0));
      mB0.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 90));
      mX0.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 180));
      mY0.whenPressed(new SetModuleAngle(Robot.TUNING_ID, 45));
    } else {
      mA0.whenPressed(new ZeroSwerve());
    }
   
  }

  public double getGamepad0Axis(int axis) {
    return MathUtils.deadband(gamepad0.getRawAxis(axis), 0.05);
  }

  public double getGamepad1Axis(int axis) {
    return MathUtils.deadband(gamepad1.getRawAxis(axis), 0.05);
  }

}
