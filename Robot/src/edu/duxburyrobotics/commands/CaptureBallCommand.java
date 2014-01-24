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
 * 
 * This command shall be called whenever the capture motor needs to spin forward
 * in order to capture the ball.
 */
public class CaptureBallCommand extends Command {
    
    protected void initialize() {
        requires(RobotMain.ballCaptureMechanism);
    }

    protected void execute() {
        RobotMain.ballCaptureMechanism.captureBall();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        RobotMain.ballCaptureMechanism.stopCapturing();
    }

    protected void interrupted() {
        end();
    }
}