/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

import edu.duxburyrobotics.robot.RobotMain;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Delete this later, they are just here for debugging purposes
 * @author Evan
 */
public class MoveBackward extends Command{
    
    public MoveBackward(){
       setTimeout(3.0);
       requires(RobotMain.drive);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        RobotMain.drive.autonomousDrive(-1.0);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        RobotMain.drive.stopDriving();
    }

    protected void interrupted() {
        end();
    }
}
