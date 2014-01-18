/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import OI.JoystickMan;
import OI.OI;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * @author Ben
 */
public class RobotTemplate extends SimpleRobot {
    
    private static DriveTrain drive;
    
    public RobotTemplate(){
        //INITS ALL OI OBJECTS
        OI.init();
        
        //create speed Controllers   TODO create custom drive train class
        SpeedController right_Motor = new Victor(1,1);
        SpeedController left_Motor = new Victor(1,2);
        
        
        drive = new DriveTrain(left_Motor, right_Motor);
        drive.setMaxOutput(1.0f);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearRight , true);
   
        drive.setSensitivity(0.2f);
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        System.out.println("Autonomous Method Called");
        drive.setSafetyEnabled(false);
        
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
            drive.arcadeDrive(OI.right_Joystick.getJoystick());
            
        }
        
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
        System.out.println("TESTMODE ACTIVATED");
    }
}
