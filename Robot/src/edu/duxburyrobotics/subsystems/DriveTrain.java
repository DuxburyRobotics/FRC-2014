
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

/**
 *
 * @author Ben, Tate
 * Creates a subclass of RobotDrive to specify our RobotDrive
 */
public class DriveTrain extends RobotDrive{
    
    public DriveTrain(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor) {
        super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }
    
    /**
     * This method should use the twist value of the joystick for turning
     * and use the throttle to control it's speed.
     * 
     * @param stick Joystick to take input from
     * @param boost Whether or not to engage maximum speed and ignore throttle speed
     */
    public void twistThrottleDrive(final Joystick stick, final boolean boost) {
        double newData = 1.0; 
        
        if(!boost){
            double throttleData = (stick.getThrottle() * -1.0 + 1.0) / 2.0;
            newData =  (((throttleData) * (1.0 - Constants.DRIVE_MIN_POWER)) / 1.0) + Constants.DRIVE_MIN_POWER; //Don't touch, magic ahead.
        }
        
        double driveSpeed = stick.getY() * newData * -1.0;
        double turnSpeed = stick.getTwist() * newData * Constants.DRIVE_TURN_MULTIPLIER * -1.0;
        
        this.arcadeDrive(driveSpeed, turnSpeed);
    }
    
    /**
     * This method should be called to drive if the user wants the choice
     * between twist turning and x-axis turning. x-axis turning sucks, so 
     * hopefully this is just for debug...
     */
    public void driveDebug(){
        if (OI.right_Joystick.getButton(2).get())       
            arcadeDrive(OI.right_Joystick.getJoystick()); //TODO: Implement throttle control
        else
            twistThrottleDrive(OI.right_Joystick.getJoystick(), OI.right_Joystick.getButton(1).get());
    }
    
    /**
     * Method to call when driving autonomously. Nicely 
     * wraps the drive() method
     *
     * @param power Value from -1.0 to 1.0 to control the speed of the motor
     */
    public void autonomousDrive(final double power) {
        drive(power, 0.0);
    }
    
    /**
     * Convenience method to stop the motors from turning
     */
    public void stopDriving() {
        drive(0.0, 0.0);
    }
    
    public void superdrive(){
        //This method must never be deleted!
        //Doing so will break the entire program!
    }
}
