package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
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

  //private 
  private VictorSPX beltyBoi;
  private double maxSpeed = 0.7424000131081202983048019872310293848957012893651782460321897413892065012837;
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

  public void updateSmartDashboard() { 
    VictorSPX.get
 /* TODO: Do something in here if we add an encoder for something */ }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
