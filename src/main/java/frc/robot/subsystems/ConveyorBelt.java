package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


/**
 * The Convyer Belt is attached to the arm and is used to pick up bunnies during the game. 
 */
public class ConveyorBelt extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //private. Use a WPI_VictorSPX
  private VictorSPX beltyBoi;
  //The motor that controls the conveyor belt
  private double maxOutput = 0.7;

  public ConveyorBelt(){
    beltyBoi = new VictorSPX(RobotMap.Ports.beltyBoi);
    beltyBoi.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    
    beltyBoi.configPeakOutputForward(maxOutput);
  }

  public void setSpeed(double speed) {
    beltyBoi.set(ControlMode.PercentOutput, speed);
  }

  public double getEncoderTicks(){
    return beltyBoi.getSelectedSensorPosition(0);
  }
  
  public void updateSmartDashboard() { 
    SmartDashboard.putNumber("Conveyor Belt Ticks", getEncoderTicks()); // Jesus please just use the SmartDashboard class
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
