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
 * @author Tate
 */
public class ToggleFrameCommand extends Command {
    
    private boolean didExecute;
        
    public ToggleFrameCommand() {
        didExecute = false;
        requires(RobotMain.ballCaptureFrame);
        setTimeout(Constants.ARM_MOVE_TIMEOUT);
    }

    protected void initialize() {}

    protected void execute() {  
        if (!didExecute) {
            if (RobotMain.ballCaptureFrame.isFrameExtended())
                RobotMain.ballCaptureFrame.retract();
            else
                RobotMain.ballCaptureFrame.extend();
            
            didExecute = true;
        }
    }

    protected boolean isFinished() {
        //Some timing may need to be implemented depending on how nice things are for us
        return isTimedOut();
    }

    protected void end() {
        didExecute = false;
    }

    protected void interrupted() {
        end();
    }
}
