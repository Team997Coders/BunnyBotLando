package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * The Convyer Belt is attached to the arm and is used to pick up bunnies during the game. 
 */
public class ConveyorBelt extends Subsystem {

  //private. Use a WPI_VictorSPX
  private VictorSPX beltyBoi;
  private double maxOutput = 0.7;

  public ConveyorBelt(){
    beltyBoi = new VictorSPX(RobotMap.Ports.INTAKE_VICTOR);
    beltyBoi.configPeakOutputForward(maxOutput);
  }

  public void setSpeed(double speed) {
    beltyBoi.set(ControlMode.PercentOutput, speed);
  }
  
  public void updateSmartDashboard() { }
  
  @Override
  public void initDefaultCommand() { }
}
