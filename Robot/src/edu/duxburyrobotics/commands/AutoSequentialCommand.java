/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Evan
 */
public class AutoSequentialCommand extends CommandGroup{
    
    public AutoSequentialCommand(){
        this.addSequential(new AutonomousCommand(), 6.0);
        this.addSequential(new AutoSendTheBitchOutCommand(),2);
    }
    
}
