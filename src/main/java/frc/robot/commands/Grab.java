package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Grab extends Command {

    static boolean grabbed = true;
    public Grab(){
        
        
    }
    
    @Override
    protected void initialize() {
        grabbed = !grabbed;
    }
    @Override
    protected void execute() {
        if (grabbed){
            Robot.mArm.grab();
        }else{
            Robot.mArm.ungrab();
        }
    }
    @Override
    protected boolean isFinished() {
        return true;
    }
}