package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Grab extends Command {

    static boolean a;

    @Override
    protected void initialize() {
        a = !a;
    }

    @Override
    protected void execute() {
        if (a) Robot.arm.grab();
        else Robot.arm.ungrab();

        System.out.println("ASD " + a);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}