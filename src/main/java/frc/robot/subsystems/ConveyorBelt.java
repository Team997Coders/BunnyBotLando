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

  private VictorSPX beltyBoi;

  /**
   * TODO: Could you add some current limits. This is an intake
   * motor and we tend to burn them often.
   */
  public ConveyorBelt(){
    beltyBoi = new VictorSPX(RobotMap.Ports.beltyBoi);
  }

  public void setSpeed(double speed) { beltyBoi.set(ControlMode.PercentOutput, speed); }

  public void updateSmartDashboard() { /* TODO: Do something in here if we add an encoder for something */ }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
