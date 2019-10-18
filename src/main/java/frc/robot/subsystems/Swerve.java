package frc.robot.subsystems;

import org.team997coders.spartanlib.commands.UpdateModule;
import org.team997coders.spartanlib.swerve.SwerveDrive;
import org.team997coders.spartanlib.swerve.module.ProtoModule;
import org.team997coders.spartanlib.swerve.module.SwerveModule;

import frc.robot.RobotMap;
import frc.robot.commands.SwerveDriveController;

public class Swerve extends SwerveDrive {

  public Swerve() {
    super(1, 1);

    super.modules = new ProtoModule[4];

    super.modules[0] = new ProtoModule(0, RobotMap.Ports.azimuth0, RobotMap.Ports.drive0, 0, 1.06, // Change
      RobotMap.Values.azimuthP, RobotMap.Values.azimuthI, RobotMap.Values.azimuthD); // TODO: Probably need to fix this later. Just remove it from the constructor set it up later
    super.modules[0].setDefaultCommand(new UpdateModule(super.modules[0], this));
    super.modules[1] = new ProtoModule(1, RobotMap.Ports.azimuth1, RobotMap.Ports.drive1, 1, 0.0,//Change
      RobotMap.Values.azimuthP, RobotMap.Values.azimuthI, RobotMap.Values.azimuthD);
    super.modules[1].setDefaultCommand(new UpdateModule(super.modules[1], this));
    super.modules[2] = new ProtoModule(2, RobotMap.Ports.azimuth2, RobotMap.Ports.drive2, 2, 0.0,//Change
      RobotMap.Values.azimuthP, RobotMap.Values.azimuthI, RobotMap.Values.azimuthD);
    super.modules[2].setDefaultCommand(new UpdateModule(super.modules[2], this));
    super.modules[3] = new ProtoModule(3, RobotMap.Ports.azimuth3, RobotMap.Ports.drive3, 3, 0.0,//Change
      RobotMap.Values.azimuthP, RobotMap.Values.azimuthI, RobotMap.Values.azimuthD);
    super.modules[3].setDefaultCommand(new UpdateModule(super.modules[3], this));

    setDefaultCommand(new SwerveDriveController());
  }

  public void UpdatePID(double p, double i, double d) {
    for (SwerveModule mod : super.modules) {
      
    }
  }

  @Override
  protected void initDefaultCommand() {
    
  }

}