package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import org.team997coders.spartanlib.commands.UpdateModule;
import org.team997coders.spartanlib.swerve.SwerveDrive;
import org.team997coders.spartanlib.swerve.module.MerlinModule;
import org.team997coders.spartanlib.swerve.module.SwerveModule;

import edu.wpi.first.wpilibj.SerialPort.Port;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.SwerveDriveController;

public class Swerve extends SwerveDrive {

  private AHRS mGyro;

  public Swerve() {
    super(1, 1);

    mGyro = new AHRS(Port.kUSB);

    mModules = new MerlinModule[4];

    mModules[0] = new MerlinModule(0, RobotMap.Ports.AZIMUTH[0], RobotMap.Ports.DRIVE[0], 0,
        RobotMap.Values.MODULE_FORWARD[0], RobotMap.Values.AZIMUTH_CONSTANTS[0]);
    mModules[1] = new MerlinModule(1, RobotMap.Ports.AZIMUTH[1], RobotMap.Ports.DRIVE[1], 1,
        RobotMap.Values.MODULE_FORWARD[1], RobotMap.Values.AZIMUTH_CONSTANTS[1]);
    mModules[2] = new MerlinModule(2, RobotMap.Ports.AZIMUTH[2], RobotMap.Ports.DRIVE[2], 2,
        RobotMap.Values.MODULE_FORWARD[2], RobotMap.Values.AZIMUTH_CONSTANTS[2]);
    mModules[3] = new MerlinModule(3, RobotMap.Ports.AZIMUTH[3], RobotMap.Ports.DRIVE[3], 3,
        RobotMap.Values.MODULE_FORWARD[3], RobotMap.Values.AZIMUTH_CONSTANTS[3]);

    mModules[1].invertDrive(true, true);

    for (int i = 0; i < mModules.length; i++) {
      mModules[i].setDriveBrakeMode(true);
      Robot.mRunner.AddAction(new UpdateModule(mModules[i], this));
    }
  }

  public void updateSmartDashboard() {
    for (SwerveModule mod : mModules) {
      mod.updateSmartDashboard();
    }
  }

  public void resetGyro() { mGyro.reset(); }

  public double getYaw() {
    double theta = mGyro.getYaw();
    while (theta < 0) theta += 360;
    while (theta >= 360) theta -= 360;
    return theta;
  }

  @Override
  protected void initDefaultCommand() {
    if (!Robot.IS_TUNING) setDefaultCommand(new SwerveDriveController());
  }

}