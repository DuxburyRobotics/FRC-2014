/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Evan
 */
public class AutonomousCommand extends Command {

    protected void initialize() {
    }

    protected void execute() {
        //System.out.println("called");
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        end();
    }
    
}
