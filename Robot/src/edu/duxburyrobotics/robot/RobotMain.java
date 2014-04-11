/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                
/*----------------------------------------------------------------------------*/

package edu.duxburyrobotics.robot;

import edu.duxburyrobotics.commands.AutoSequentialCommand;
import edu.duxburyrobotics.io.OI;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.duxburyrobotics.subsystems.RearGate;
import edu.duxburyrobotics.subsystems.BallCaptureMechanism;
import edu.duxburyrobotics.subsystems.DriveTrain;
import edu.duxburyrobotics.subsystems.BallCaptureFrame;
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
    
    public static DriveTrain driveTrain;
    public static BallCaptureFrame ballCaptureFrame;
    public static BallCaptureMechanism ballCaptureMechanism;
    public static RearGate backDrop;    
    public static CommandGroup autoCommand;
    
    public RobotMain(){
        initSubsystems();
        initOI();
        
        autoCommand = new AutoSequentialCommand();
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
        backDrop = new RearGate();
        driveTrain = new DriveTrain();
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        if (autoCommand != null)
            autoCommand.start();
        else
            System.out.println("Autonomous command is NULL!");
        
        while(isAutonomous() && isEnabled())
            Scheduler.getInstance().run();
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
      
        if (autoCommand != null) autoCommand.cancel();
        
        while (isEnabled() && isOperatorControl()){
            Scheduler.getInstance().run();
            OI.updateDashboard();
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
        System.out.println("TESTMODE ACTIVATED LELELELELELE");
    }
}
