/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Tate
 */
public class BallCaptureMechanism extends Subsystem {
    
    private final Victor captureMotorController;
    
    public BallCaptureMechanism() {
        captureMotorController = new Victor(1, Constants.MOTOR_PORT_CAPTURE);
    }

    protected void initDefaultCommand() {}
    
    /**
     * @param value 
     */
    public void spinController(final double value){
        double power = value * 0.25;
        moveCaptureMotor(power);
    }
    
    public void moveCaptureMotor(final double moveValue){
        captureMotorController.set(moveValue);
    }
}
