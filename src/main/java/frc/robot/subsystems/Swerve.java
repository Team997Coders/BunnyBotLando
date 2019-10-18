package frc.robot.subsystems;

import org.team997coders.spartanlib.commands.UpdateModule;
import org.team997coders.spartanlib.swerve.SwerveDrive;
import org.team997coders.spartanlib.swerve.module.ProtoModule;
import org.team997coders.spartanlib.swerve.module.SwerveModule;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.SwerveDriveController;

public class Swerve extends SwerveDrive {

  public Swerve() {
    super(1, 1);

    mModules = new ProtoModule[4];

    mModules[0] = new ProtoModule(0, RobotMap.Ports.AZIMUTH_0, RobotMap.Ports.DRIVE_0, 0, RobotMap.Values.MODULE_FORWARD_0, // Change
      RobotMap.Values.AZIMUTH_P, RobotMap.Values.AZIMUTH_I, RobotMap.Values.AZIMUTH_D);
    mModules[1] = new ProtoModule(1, RobotMap.Ports.AZIMUTH_1, RobotMap.Ports.DRIVE_1, 1, RobotMap.Values.MODULE_FORWARD_1, //Change
      RobotMap.Values.AZIMUTH_P, RobotMap.Values.AZIMUTH_I, RobotMap.Values.AZIMUTH_D);
    mModules[2] = new ProtoModule(2, RobotMap.Ports.AZIMUTH_2, RobotMap.Ports.DRIVE_2, 2, RobotMap.Values.MODULE_FORWARD_2, //Change
      RobotMap.Values.AZIMUTH_P, RobotMap.Values.AZIMUTH_I, RobotMap.Values.AZIMUTH_D);
    mModules[3] = new ProtoModule(3, RobotMap.Ports.AZIMUTH_3, RobotMap.Ports.DRIVE_3, 3, RobotMap.Values.MODULE_FORWARD_3, //Change
      RobotMap.Values.AZIMUTH_P, RobotMap.Values.AZIMUTH_I, RobotMap.Values.AZIMUTH_D);

    for (int i = 0; i < mModules.length; i++) {
      Robot.getRunner().AddAction(new UpdateModule(mModules[i], this));
    }

    setDefaultCommand(new SwerveDriveController());
  }

  public void updateSmartDashboard() {
    for (SwerveModule mod : mModules) {
      mod.updateSmartDashboard();
    }
  }

  @Override
  protected void initDefaultCommand() {
    
  }

}