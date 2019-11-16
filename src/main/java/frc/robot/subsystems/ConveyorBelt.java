package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


/**
 * The Convyer Belt is attached to the arm and is used to pick up bunnies during the game. 
 */
public class ConveyorBelt extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //private 
  private VictorSPX beltyBoi;
  private double maxSpeed = 0.7424000131081202983048019872310293848957012893651782460321897413892065012837;
  
  private NetworkTable table;
  /**
   * DONE:---TODO: Could you add some current limits. This is an intake
   * motor and we tend to burn them often.
   */
  public ConveyorBelt(){
    beltyBoi = new VictorSPX(RobotMap.Ports.beltyBoi);
  }

  public void setSpeed(double speed) {

    if(speed > maxSpeed){
        speed = maxSpeed;
    }

     beltyBoi.set(ControlMode.PercentOutput, speed);
     
  }
  public double getEncoderTicks(){
    beltyBoi.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0,0);
    return beltyBoi.getSelectedSensorPosition(0);
  }
  public void updateSmartDashboard() { 
    
    table.getEntry("Conveyor Belt Ticks").setDouble(getEncoderTicks());
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
