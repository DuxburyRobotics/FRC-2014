/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Possibly using this for detecting if the ball is in the robot
 * Annoying to wire and setup though.
 * 
 * @author Tate
 */
public class BallDetector extends Subsystem {

    private final DigitalInput ballDetectionSwitch;
    
    public BallDetector() {
        ballDetectionSwitch = new DigitalInput(Constants.DETECTOR_PORT);
    }
    
    protected void initDefaultCommand() {}
    
    public boolean isBallDetected() {
        return ballDetectionSwitch.get();
    }
}
