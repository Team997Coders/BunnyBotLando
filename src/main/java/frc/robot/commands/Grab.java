package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Grab extends Command {

    boolean a;

    public Grab(boolean a) { this.a = a; }

    @Override
    protected void execute() {
        if (a) Robot.arm.grab();
        else Robot.arm.ungrab();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}