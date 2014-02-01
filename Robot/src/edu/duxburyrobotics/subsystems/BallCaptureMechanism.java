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
     * @param joystick the Joystick object that will control
     * the spinner on top. works off its Y axis
     */
    public void spinController(Joystick joystick){
        //the Y value of the stick
        double y = joystick.getY();
        
        //reduce the y value to 1/4 its value in order to keep it slow.
        y /= 5;
        
        //move the mechinism by that value
        moveBallMechinism(y);
    }
    
    public void moveBallMechinism(double moveValue){
        captureMotorController.set(moveValue);
    }
    
    public void captureBall() {
        captureMotorController.set(1.0);
        //Perhaps gradually accelerate speed of motor to make more
        //efficient and less damaging to parts.
    }
    
    public void releaseBall() {
        captureMotorController.set(-1.0);
    }
    
    public void stopCapturing() {
        captureMotorController.set(0.0);
        captureMotorController.stopMotor();
        //Perhaps use PID controller to quickly stop the motor
    }
}
