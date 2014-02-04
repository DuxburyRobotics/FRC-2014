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
public class ExtendFrameCommand extends Command{
    
    public ExtendFrameCommand(){
        requires(RobotMain.ballCaptureFrame);
        
        //set timeout may need to adjust
        setTimeout(Constants.ARM_MOVE_TIMEOUT);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        RobotMain.ballCaptureFrame.extend();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        
    }

    protected void interrupted() {
        end();
    }
    
}
