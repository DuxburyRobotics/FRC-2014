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
public class ToggleBackCommand extends Command{
    
    private boolean executed;
    
    public ToggleBackCommand(){
        executed = false;
        requires(RobotMain.backDrop);
    }

    protected void initialize() {
        executed = false;
    }

    protected void execute() {
        if (!executed){
            if (RobotMain.backDrop.isDropped()){
                RobotMain.backDrop.LiftDaBack();
            }else{
                RobotMain.backDrop.dropDaBack();
            }
            executed = true;
        }
        
    }

    protected boolean isFinished() {
        return isExecuted();
    }

    protected void end() {
        executed = false;
    }

    protected void interrupted() {
        end();
    }
    
    private boolean isExecuted(){
        return executed;
    }
    
    
    
}
