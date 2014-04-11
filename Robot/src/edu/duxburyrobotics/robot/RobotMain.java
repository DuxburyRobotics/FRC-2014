/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                
/*----------------------------------------------------------------------------*/

package edu.duxburyrobotics.robot;

import edu.duxburyrobotics.commands.AutoSequentialCommand;
import edu.duxburyrobotics.commands.AutonomousCommand;
import edu.duxburyrobotics.commands.ManipulateBallCommand;
import edu.duxburyrobotics.commands.ToggleFrameCommand;
import edu.duxburyrobotics.io.OI;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.duxburyrobotics.helpers.Constants;
import edu.duxburyrobotics.subsystems.BackDrop;
import edu.duxburyrobotics.subsystems.BallCaptureMechanism;
import edu.duxburyrobotics.subsystems.DriveTrain;
import edu.duxburyrobotics.subsystems.BallCaptureFrame;
import edu.duxburyrobotics.subsystems.BallReleaseHatch;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * @author Duxbury Robotics Programming Team 4908
 */
public class RobotMain extends SimpleRobot {
    
    public static DriveTrain drive;
    public static BallCaptureFrame ballCaptureFrame;
    public static BallCaptureMechanism ballCaptureMechanism;
<<<<<<< HEAD
    public static BallReleaseHatch ballReleaseHatch;
=======
    public static BackDrop backDrop;
>>>>>>> 4a69f35ea7f9adde0b76f0740c49a60752254442
    
    public static CommandGroup autoCommand;
    
    public RobotMain(){
        initSubsystems();
        initOI();
        
        autoCommand = new AutoSequentialCommand();
        System.out.println("Constructor called");
    }
    
    /**
     * Initializes OI class as well as any input devices
     */
    private void initOI() {
         OI.init();
    }
    
    /**
     * Initializes all subsystems of robot
     */
    private void initSubsystems() {
        ballCaptureFrame = new BallCaptureFrame();
        ballCaptureMechanism = new BallCaptureMechanism();
<<<<<<< HEAD
        ballReleaseHatch = new BallReleaseHatch();
=======
        backDrop = new BackDrop();
        //creates the drivetrain as a subsytem, that way we can use commands for debugging
        drive = new DriveTrain();
>>>>>>> 4a69f35ea7f9adde0b76f0740c49a60752254442
    }
    
    /**
     * Initializes the drive train of the robot
     */
    private void initDriveTrain() {
        //TODO: These need to be changed to match physical setup!
        Jaguar rightMotor1 = new Jaguar(1, Constants.MOTOR_PORT_RIGHT1);
        Jaguar leftMotor1 = new Jaguar(1, Constants.MOTOR_PORT_LEFT1);
        Victor rightMotor2  = new Victor(1, Constants.MOTOR_PORT_RIGHT2);
        Jaguar leftMotor2 = new Jaguar(1, Constants.MOTOR_PORT_LEFT2);
  
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
         if (autoCommand != null){
              autoCommand.start();
              System.out.println("AutoCommand is not null");
          }
         
      while(isAutonomous() && isEnabled()){
         Scheduler.getInstance().run();
      }

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
      
       // drive.setSafetyEnabled(true);
        if (autoCommand != null) autoCommand.cancel();
        
        while (isEnabled() && isOperatorControl()){
            
            // this will update the dashboard and make sure everything running smoothly
            Scheduler.getInstance().run();
            OI.updateDashboard();
           // drive.twistThrottleDrive(OI.right_Joystick.getJoystick(), 
            //        OI.right_Joystick.getButton(Constants.BUTTON_SPEED_BOOST).get());
        }
        System.out.println("We have passed the isEnable() isOperatorControl() while loop.");
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
        System.out.println("TESTMODE ACTIVATED LELELELELELE");
    }
    
  
}
