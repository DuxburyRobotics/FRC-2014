/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

import edu.duxburyrobotics.helpers.Constants;
import edu.duxburyrobotics.robot.RobotMain;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Evan
 */
public class RetractFrameCommand extends Command{
    
    boolean executed = false;
    public RetractFrameCommand(){
        //  the subsystem it requires
        requires(RobotMain.ballCaptureFrame);
        
        //  we may need to adjust this value as appropriate, or it may work
        setTimeout(Constants.ARM_MOVE_TIMEOUT);
    }

    protected void initialize() {
       executed = false;
    }

    protected void execute() {
       // if (!executed){
            RobotMain.ballCaptureFrame.retract();
        //    executed = true;
      //  }
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        
    }

    protected void interrupted() {
        end();
    }
    
    private boolean isExecuted(){
        return executed;
    }
    
}
