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
 * @author Evan, Tate
 * 
 * This command will just operate the spinner based off the 
 * Y axis of the Left JoyStick
 */
public class ManipulateBallCommand extends Command {
    
    public ManipulateBallCommand(){
        this.requires(RobotMain.ballCaptureMechanism);
    }

    protected void initialize() {}

    protected void execute() {
        RobotMain.ballCaptureMechanism.spinController(OI.left_Joystick.getJoystick().getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        //stop the spinning
        RobotMain.ballCaptureMechanism.spinController(0);
    }

    protected void interrupted() {
        end();
    }
}
