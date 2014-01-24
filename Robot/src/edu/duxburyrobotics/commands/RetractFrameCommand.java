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
 * @author Evan
 */
public class RetractFrameCommand extends Command{

    protected void initialize() {
        requires(RobotMain.ballCaptureFrame);
    }

    protected void execute() {
        RobotMain.ballCaptureFrame.retract();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        RobotMain.ballCaptureFrame.stopMoving();
    }

    protected void interrupted() {
        end();
    }
    
}
