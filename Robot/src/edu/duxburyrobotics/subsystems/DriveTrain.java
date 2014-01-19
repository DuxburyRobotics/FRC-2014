/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.helpers.Constants;
import edu.duxburyrobotics.io.OI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.communication.Semaphore;

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
    public void twistThrottleDrive(final Joystick stick, boolean boost) {
        double newData = 1; 
        
        if(!boost){
            double throttleData = (stick.getThrottle() * -1.0 + 1.0) / 2.0;
            newData =  (((throttleData) * (1.0 - Constants.DRIVE_MIN_POWER)) / 1.0) + Constants.DRIVE_MIN_POWER; //Don't touch, magic ahead.
        }
        
        double driveSpeed = stick.getY() * newData;
        double turnSpeed = stick.getTwist() * newData * Constants.DRIVE_TURN_MULTIPLIER;
        
        this.arcadeDrive(driveSpeed, turnSpeed);
    }
    
    public void drive(){
        double speedMod = 1.0;
        if (OI.right_Joystick.getButton(2).get()) {            
            arcadeDrive(OI.right_Joystick.getJoystick()); //TODO: Implement throttle control
        } else{
            twistThrottleDrive(OI.right_Joystick.getJoystick(), OI.right_Joystick.getButton(1).get());
        }
    }
    
    public void superdrive(){
        //SUPER AWESOME DRIVING METHODE HERE
        //FAPFAPFAPFAPFAP ;D 
    }
}
