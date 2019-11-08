package frc.robot.subsystems;

import org.team997coders.spartanlib.commands.UpdateModule;
import org.team997coders.spartanlib.swerve.SwerveDrive;
import org.team997coders.spartanlib.swerve.module.HybridModule;
import org.team997coders.spartanlib.swerve.module.SwerveModule;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.SwerveDriveController;

public class Swerve extends SwerveDrive {

  public Swerve() {
    super(1, 1);

    mModules = new HybridModule[4];

    mModules[0] = new HybridModule(0, RobotMap.Ports.AZIMUTH[0], RobotMap.Ports.DRIVE[0], 0,
        RobotMap.Values.MODULE_FORWARD[0], // Change
        RobotMap.Values.AZIMUTH_P[0], RobotMap.Values.AZIMUTH_I[0], RobotMap.Values.AZIMUTH_D[0]);
    mModules[1] = new HybridModule(1, RobotMap.Ports.AZIMUTH[1], RobotMap.Ports.DRIVE[1], 1,
        RobotMap.Values.MODULE_FORWARD[1], // Change
        RobotMap.Values.AZIMUTH_P[1], RobotMap.Values.AZIMUTH_I[1], RobotMap.Values.AZIMUTH_D[1]);
    mModules[2] = new HybridModule(2, RobotMap.Ports.AZIMUTH[2], RobotMap.Ports.DRIVE[2], 2,
        RobotMap.Values.MODULE_FORWARD[2], // Change
        RobotMap.Values.AZIMUTH_P[2], RobotMap.Values.AZIMUTH_I[2], RobotMap.Values.AZIMUTH_D[2]);
    mModules[3] = new HybridModule(3, RobotMap.Ports.AZIMUTH[3], RobotMap.Ports.DRIVE[3], 3,
        RobotMap.Values.MODULE_FORWARD[3], // Change
        RobotMap.Values.AZIMUTH_P[3], RobotMap.Values.AZIMUTH_I[3], RobotMap.Values.AZIMUTH_D[3]);

    mModules[0].invertAzimuth(true);
    //mModules[1].invertAzimuth(true);

    for (int i = 0; i < mModules.length; i++) {
      Robot.mRunner.AddAction(new UpdateModule(mModules[i], this));
    }
  }

  public void updateSmartDashboard() {
    for (SwerveModule mod : mModules) {
      mod.updateSmartDashboard();
    }
  }

  @Override
  protected void initDefaultCommand() {
    if (!Robot.IS_TUNING) setDefaultCommand(new SwerveDriveController());
  }

}