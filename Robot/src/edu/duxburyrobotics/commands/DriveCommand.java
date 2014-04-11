/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

import edu.duxburyrobotics.helpers.Constants;
import edu.duxburyrobotics.io.OI;
import edu.duxburyrobotics.robot.RobotMain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Evan
 */
public class DriveCommand extends Command{
    
    public DriveCommand(){
        requires(RobotMain.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
        /*
        Joystick joy = OI.right_Joystick.getJoystick();
        boolean speedBoost = OI.right_Joystick.getButton(Constants.BUTTON_SPEED_BOOST).get();
        RobotMain.drive.twistThrottleDrive(joy,speedBoost);
        */
        
        RobotMain.drive.driveDebug();
    }

    protected boolean isFinished() {
        //drive never returns true
        return false;
    }

    protected void end() {
        RobotMain.drive.stopDriving();
    }

    protected void interrupted() {
        end();
    }
    
}
