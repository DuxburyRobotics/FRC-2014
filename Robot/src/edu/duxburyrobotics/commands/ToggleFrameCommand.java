/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

import edu.duxburyrobotics.robot.RobotMain;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Tate
 */
public class ToggleFrameCommand extends Command {
    
    private boolean startingState;

    protected void initialize() {
        requires(RobotMain.ballCaptureFrame);
        startingState = RobotMain.ballCaptureFrame.isFrameExtended();
    }

    protected void execute() {
        if (RobotMain.ballCaptureFrame.isFrameExtended())
            RobotMain.ballCaptureFrame.retract();
        else
            RobotMain.ballCaptureFrame.extend();
    }

    protected boolean isFinished() {
        //Some timing may need to be implemented depending on how nice things are for us
        return startingState != RobotMain.ballCaptureFrame.isFrameExtended();
    }

    protected void end() {
        
    }

    protected void interrupted() {
        System.out.println("ToggleFrameCommand interupted! You're doing something wrong!");
        end();
    }
}
