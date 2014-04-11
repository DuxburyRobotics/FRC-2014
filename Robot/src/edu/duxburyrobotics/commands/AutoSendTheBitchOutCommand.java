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
public class AutoSendTheBitchOutCommand extends Command{

    public AutoSendTheBitchOutCommand(){
        this.requires(RobotMain.ballCaptureMechanism);
    }
    protected void initialize() {
        
    }

    protected void execute() {
        RobotMain.ballCaptureMechanism.spinController(-1.0f);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        RobotMain.ballCaptureMechanism.spinController(0);
    }

    protected void interrupted() {
        end();
    }
    
}
