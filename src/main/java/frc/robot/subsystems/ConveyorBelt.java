package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * TODO: Make a ConveyorBelt describtion
 */
public class ConveyorBelt extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  // TODO: Make this a private variable
  VictorSPX beltyBoi;

  /**
   * TODO: Could you add some current limits. This is an intake
   * motor and we tend to burn them often.
   */
  public ConveyorBelt(){
    beltyBoi = new VictorSPX(RobotMap.beltyBoi);
  }

  /**
   * TODO: Please just make one function that takes a parameter
   * for speed. Making 3 functions that all do relatively the same thing
   * but a bit different is excessive.
   */
  public void ConveyorForward(){
    beltyBoi.set(ControlMode.PercentOutput, .5);
  }

  public void ConveyorBackward(){
    beltyBoi.set(ControlMode.PercentOutput, -.5);
  }

  public void ConveyorStop(){
    beltyBoi.set(ControlMode.PercentOutput, 0);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
