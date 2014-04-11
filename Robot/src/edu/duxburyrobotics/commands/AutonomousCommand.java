/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.commands;

import edu.duxburyrobotics.robot.RobotMain;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Evan
 */
public class AutonomousCommand extends Command{
    
    public AutonomousCommand(){
        this.requires(RobotMain.driveTrain);
    }

    protected void initialize() {
     //   this.setTimeout(SmartDashboard.getNumber("Timeout"));
    //    System.out.println("Auto Init has been called.");
     //   System.out.println(SmartDashboard.getNumber("Timeout"));
//        this.setTimeout(5.25/18*15);
    }

    protected void execute() {
      //  System.out.println("WE ARE EXECTUING");
        RobotMain.driveTrain.autonomousDrive(-0.4);
    }

    protected boolean isFinished() {
        //System.out.println("WE CHECKED IF WE FINISHED");
        //System.out.println(isTimedOut());
        return isTimedOut();
    }

    protected void end() {
        RobotMain.driveTrain.stopDriving();
       // System.out.println("AUTO ENDED");
    }

    protected void interrupted() {
        //System.out.println("auton is being interuppted.");
        end();
    }
    
}
