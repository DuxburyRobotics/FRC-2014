/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Tate
 */
public class BallCaptureMechanism extends Subsystem {
    
    private final Jaguar captureMotorController;
    
    public BallCaptureMechanism() {
        captureMotorController = new Jaguar(1, Constants.MOTOR_PORT_CAPTURE);
    }

    protected void initDefaultCommand() {
        //No default command for this subsystem
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
