/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author Ben
 * Creates a subclass of RobotDrive to specify our RobotDrive
 */
public class DriveTrain extends RobotDrive{

    public DriveTrain(SpeedController leftMotor, SpeedController rightMotor) {
        super(leftMotor, rightMotor);
    }
    
    /**
     * This method should use the twist value of the joystick for turning
     * and use the throttle to control it's speed.
     * 
     * @param stick Joystick to take input from
     */
    public void twistThrottleDrive(Joystick stick) {
        double throttleData = stick.getThrottle();
        if (throttleData == 0)
            throttleData = Constants.DRIVE_MIN_POWER;
        double driveSpeed = stick.getY() * throttleData;
        double turnSpeed = stick.getTwist() * throttleData;
        
        this.arcadeDrive(driveSpeed, turnSpeed);
    }
    
    public void superdrive(){
        //SUPER AWESOME DRIVING METHODE HERE
        //FAPFAPFAPFAPFAP
    }
}
