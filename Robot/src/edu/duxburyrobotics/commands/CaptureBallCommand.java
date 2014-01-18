/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

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
        
    }

    protected void execute() {
        //capture ball
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        //stop motor
    }

    protected void interrupted() {
        end();
    }
}