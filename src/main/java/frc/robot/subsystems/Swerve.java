package frc.robot.subsystems;

import java.util.ArrayList;

import com.kauailabs.navx.frc.AHRS;

import org.team997coders.spartanlib.commands.UpdateModule;
import org.team997coders.spartanlib.helpers.threading.SpartanRunner;
import org.team997coders.spartanlib.math.Vector2;
import org.team997coders.spartanlib.swerve.SwerveDrive;
import org.team997coders.spartanlib.swerve.module.TorqueModule;
import org.team997coders.spartanlib.swerve.module.SwerveModule;

import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.drive.Vector2d;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.drive.SwerveDriveController;

public class Swerve extends SwerveDrive {

  private AHRS mGyro;

  public Swerve() {
    super(1, 1);

    mGyro = new AHRS(Port.kUSB);

    mModules = new TorqueModule[4];

    mModules[0] = new TorqueModule(0, RobotMap.Ports.AZIMUTH[0], RobotMap.Ports.DRIVE[0], 2,
        RobotMap.Values.MODULE_FORWARD[0], RobotMap.Values.AZIMUTH_CONSTANTS[0], RobotMap.Values.DRIVE_CONSTANTS[0]);
    mModules[1] = new TorqueModule(1, RobotMap.Ports.AZIMUTH[1], RobotMap.Ports.DRIVE[1], 1,
        RobotMap.Values.MODULE_FORWARD[1], RobotMap.Values.AZIMUTH_CONSTANTS[1], RobotMap.Values.DRIVE_CONSTANTS[1]);
    mModules[2] = new TorqueModule(2, RobotMap.Ports.AZIMUTH[2], RobotMap.Ports.DRIVE[2], 3,
        RobotMap.Values.MODULE_FORWARD[2], RobotMap.Values.AZIMUTH_CONSTANTS[2], RobotMap.Values.DRIVE_CONSTANTS[2]);
    mModules[3] = new TorqueModule(3, RobotMap.Ports.AZIMUTH[3], RobotMap.Ports.DRIVE[3], 0,
        RobotMap.Values.MODULE_FORWARD[3], RobotMap.Values.AZIMUTH_CONSTANTS[3], RobotMap.Values.DRIVE_CONSTANTS[3]);

    //mModules[3].invertDrive(true, true);
    //mModules[0].invertDrive(true, true);

    for (int i = 0; i < mModules.length; i++) {
      mModules[i].setDriveBrakeMode(true);
      SpartanRunner.LockThread();
      Robot.mRunner.AddAction(new UpdateModule(mModules[i], this));
      SpartanRunner.UnlockThread();
    }
  }

  public Vector2 getSpeedVector() {
    ArrayList<Vector2> vects = new ArrayList<Vector2>();
    for (int i = 0; i < mModules.length; i++) {
      vects.add(mModules[i].getSpeedVector());
    }

    Vector2 sum = new Vector2(0, 0);

    vects.forEach((vect) -> {
      sum.x += vect.x;
      sum.y += vect.y;
    });

    Vector2 avg = new Vector2(sum.x / vects.size(), sum.y / vects.size());
    return avg;
  }

  public void updateSmartDashboard() {
    for (SwerveModule<Object, Object, Object> mod : mModules) {
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