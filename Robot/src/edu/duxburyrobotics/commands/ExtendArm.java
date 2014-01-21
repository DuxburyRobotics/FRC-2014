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
public class ExtendArm extends Command{
    
    public ExtendArm()
    {
        requires(RobotMain.pnumatics);
    }

    protected void initialize() {
    }

    protected void execute() {
        RobotMain.pnumatics.extend();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        RobotMain.pnumatics.stopMoving();
    }

    protected void interrupted() {
        end();
    }
    
}
