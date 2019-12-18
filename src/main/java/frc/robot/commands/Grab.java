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
            Robot.arm.grab();
        }else{
            Robot.arm.ungrab();
        }
    }
    @Override
    protected boolean isFinished() {
        return true;
    }
}