/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

import edu.duxburyrobotics.io.OI;
import edu.duxburyrobotics.robot.RobotMain;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Evan
 * 
 * This command will just operate the spinner based off the 
 * Y axis of the Left JoyStick
 */
public class BallCommand extends Command{
    
    public void BallCommand(){
        requires(RobotMain.ballCaptureMechanism);
        
    }

    protected void initialize() {
    }

    protected void execute() {
        
        RobotMain.ballCaptureMechanism.spinController(OI.left_Joystick.getJoystick());
    }

    protected boolean isFinished() {
        return false; // we want this to never return true.
    }

    protected void end() {
        RobotMain.ballCaptureMechanism.stopCapturing();
    }

    protected void interrupted() {
        end();
    }
    
}
