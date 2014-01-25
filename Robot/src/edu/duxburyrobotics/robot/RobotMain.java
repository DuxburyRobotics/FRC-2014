/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                
/*----------------------------------------------------------------------------*/

package edu.duxburyrobotics.robot;


import edu.duxburyrobotics.commands.CaptureBallCommand;
import edu.duxburyrobotics.commands.ToggleFrameCommand;
import edu.duxburyrobotics.io.OI;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.duxburyrobotics.helpers.Constants;
import edu.duxburyrobotics.subsystems.BallCaptureMechanism;
import edu.duxburyrobotics.subsystems.DriveTrain;
import edu.duxburyrobotics.subsystems.BallCaptureFrame;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * @author Ben
 */
public class RobotMain extends SimpleRobot {
    
    public static DriveTrain drive;
    public static BallCaptureFrame ballCaptureFrame;
    public static BallCaptureMechanism ballCaptureMechanism;
    
    public RobotMain(){
        initOI();
        initSubsystems();
        initDriveTrain();
    }
    
    private void initOI() {
         OI.init();
         
         //The following joystick buttons need to be changed
         //OI.left_Joystick.getButton(Constants.BUTTON_CAPTURE_BALL).whileHeld(new CaptureBallCommand());
         //OI.right_Joystick.getButton(Constants.BUTTON_TOGGLE_FRAME).whenPressed(new ToggleFrameCommand());
    }
    
    private void initSubsystems() {
        ballCaptureFrame = new BallCaptureFrame();
        ballCaptureMechanism = new BallCaptureMechanism();
    }
    
    private void initDriveTrain() {        
        Jaguar rightMotor1 = new Jaguar(1, Constants.MOTOR_PORT_RIGHT1);
        Jaguar leftMotor1 = new Jaguar(1, Constants.MOTOR_PORT_LEFT1);
        Victor rightMotor2 = new Victor(1, Constants.MOTOR_PORT_RIGHT2);
        Victor leftMotor2 = new Victor(1, Constants.MOTOR_PORT_LEFT2);
        
        drive = new DriveTrain(leftMotor1, leftMotor2, rightMotor1, rightMotor2);
        drive.setMaxOutput(Constants.DRIVE_MAX_POWER);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight , true);
        //TODO: Invert extra motors if necessary!
   
        drive.setSensitivity(Constants.DRIVE_SENSITIVITY);
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        System.out.println("Autonomous Mode Enabled");
        
        /* Old auto driving
        drive.setSafetyEnabled(false);
        for (int i = 0; i < 1000; i++)
            drive.autonomousDrive(1.0);
        */
        /*
        Test for possibly better autonomous driving
        This makes it time based instead of iteration based.
        Better because our variable is a constant time, not 
        iterations which may change slightly depending on
        conditions in the CPU
        */
        
        //This drives exactly 10 feet (including drift) with the bumpers
        //attached
        drive.setSafetyEnabled(false);
        drive.autonomousDrive(0.75);
        Timer.delay(2.5);
        drive.stopDriving();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        //So we know when ready for teleop
        System.out.println("/***********************************/");
        System.out.println("*                                  *");
        System.out.println("Operator Controller method called  *");
        System.out.println("*                                  *");
        System.out.println("/***********************************/");
      
        drive.setSafetyEnabled(true);
        
        while (isEnabled() && isOperatorControl()){
            drive.twistThrottleDrive(OI.right_Joystick.getJoystick(), 
                    OI.right_Joystick.getButton(Constants.BUTTON_SPEED_BOOST).get());
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
        System.out.println("TESTMODE ACTIVATED");
    }
}
