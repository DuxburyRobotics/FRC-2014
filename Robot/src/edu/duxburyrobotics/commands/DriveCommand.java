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
public class DriveCommand extends Command{
    
    public DriveCommand(){
        requires(RobotMain.driveTrain);
    }

    protected void initialize() { }

    protected void execute() {        
        //RobotMain.driveTrain.driveDebug();
        RobotMain.driveTrain.eliteDrive();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        RobotMain.driveTrain.stopDriving();
    }

    protected void interrupted() {
        end();
    }
}
