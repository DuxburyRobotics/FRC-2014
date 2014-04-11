/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.commands.ManipulateBallCommand;
import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Tate
 */
public class BallCaptureMechanism extends Subsystem {
    
    private Victor captureMotorController;
    private RobotDrive robo;
    
    public BallCaptureMechanism() {
        captureMotorController = new Victor(1, Constants.MOTOR_PORT_CAPTURE);
        captureMotorController.setSafetyEnabled(true);
        //robo = new RobotDrive(captureMotorController, captureMotorController);
        //robo.setSafetyEnabled(true);
    }

    protected void initDefaultCommand() {
        //this being the default command it will always listen for 
        //left joystick input.
        this.setDefaultCommand(new ManipulateBallCommand());
        
    }
    
    /**
     * 
     * @param value - Raw value in the range of -1.0 to 1.0
     */
    public void spinController(final double value){
        double power = value;// * 0.25;
        captureMotorController.set(power);
        //System.out.println(value);
        //captureMotorController.set
       //robo.tankDrive(value, value);
    }
    
    public Victor getMotor(){
        return captureMotorController;
    }
}
