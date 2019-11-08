package frc.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class UpdateSwervePID {

  private double mLastP, mLastI, mLastD;

  public UpdateSwervePID(int moduleID) {
    
    mLastP = RobotMap.Values.AZIMUTH_P[moduleID];
    mLastI = RobotMap.Values.AZIMUTH_I[moduleID];
    mLastD = RobotMap.Values.AZIMUTH_D[moduleID];

    SmartDashboard.putNumber("swerve/aziP", mLastP);
    SmartDashboard.putNumber("swerve/aziI", mLastI);
    SmartDashboard.putNumber("swerve/aziD", mLastD);

    SmartDashboard.setPersistent("swerve/aziP");
    SmartDashboard.setPersistent("swerve/aziI");
    SmartDashboard.setPersistent("swerve/aziD");
  }

  public void update() {
    double p = SmartDashboard.getNumber("swerve/aziP", 0.0);
    double i = SmartDashboard.getNumber("swerve/aziI", 0.0);
    double d = SmartDashboard.getNumber("swerve/aziD", 0.0);

    if ((p != mLastP || i != mLastI) || d != mLastD) {
      Robot.mSwerve.updateAzimuthPID(p, i, d);
    }
  }

}