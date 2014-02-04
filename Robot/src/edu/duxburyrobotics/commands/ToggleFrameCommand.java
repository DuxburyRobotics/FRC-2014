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
    private boolean goUp;
        
    public ToggleFrameCommand() {
        didExecute = false;
        goUp = false;
        requires(RobotMain.ballCaptureFrame);
        setTimeout(Constants.ARM_MOVE_TIMEOUT);
    }

    protected void initialize() {
        if (RobotMain.ballCaptureFrame.isFrameExtended()){
            goUp = true;
        }else{
            goUp = false;
        }
    }

    protected void execute() {  
        /*
        if (!didExecute) {
            if (RobotMain.ballCaptureFrame.isFrameExtended())
                RobotMain.ballCaptureFrame.retract();
            else
                RobotMain.ballCaptureFrame.extend();
            
            didExecute = true;
        }
         */
        if (goUp){
            RobotMain.ballCaptureFrame.retract();
        }else if (!goUp){
            RobotMain.ballCaptureFrame.extend();
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
