
package edu.duxburyrobotics.io;

import edu.duxburyrobotics.commands.ExtendFrameCommand;
import edu.duxburyrobotics.commands.MoveBackward;
import edu.duxburyrobotics.commands.MoveForward;
import edu.duxburyrobotics.commands.RetractFrameCommand;
import edu.duxburyrobotics.commands.ToggleBackCommand;
import edu.duxburyrobotics.commands.ToggleFrameCommand;
import edu.duxburyrobotics.helpers.Constants;
import edu.duxburyrobotics.robot.RobotMain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Evan Ben
 * Holds all OI Objects
 * Inits all OI Objects
 */
public class OI {
    
    //variables
    public static final int rightJoystickInputValue = 1;
    public static final int leftJoystickInputValue = 2;
    
    // two joySticks for the operator to work with
    public static Enjoystick right_Joystick;
    public static Enjoystick left_Joystick;
    
    //Inits all OI Objects
    public static void init(){
        initLeftStick();
        initRightStick();
        initDashboard();
    }
    
    private static void initRightStick() {
        right_Joystick = new Enjoystick(new Joystick(rightJoystickInputValue));
        right_Joystick.createButton(Constants.BUTTON_SPEED_BOOST);
    }
    
    
    private static void initLeftStick(){
        left_Joystick = new Enjoystick(new Joystick(leftJoystickInputValue));
        left_Joystick.createButton(Constants.BUTTON_TOGGLE_FRAME, 1 , new ToggleFrameCommand(), 0);
        left_Joystick.createButton(Constants.Button_Toggle_Back, 0, new ToggleBackCommand(), 1);
    }
    
    private static void initDashboard(){
        SmartDashboard.putData("Move Forward 3 seconds", new MoveForward());
        SmartDashboard.putData("Move Backward 3 seconds", new MoveBackward());
        SmartDashboard.putData("Lower Arm", new ExtendFrameCommand());
        SmartDashboard.putData("Raise Arm", new RetractFrameCommand());
        SmartDashboard.putData("Toggle arm", new ToggleFrameCommand());
        SmartDashboard.putNumber("Timeout", 2);
        SmartDashboard.putNumber("SPEED", -1.0);
        SmartDashboard.putNumber("Right Joystick: Y-value ", OI.right_Joystick.getJoystick().getY());
        SmartDashboard.putNumber("Left Joystick: Y-value ", OI.left_Joystick.getJoystick().getY());
        SmartDashboard.putNumber("Left Motor 1 : Speed: ", RobotMain.driveTrain.getLeftMotor().getSpeed());
        SmartDashboard.putNumber("Left Motor 2 : Speed: ", RobotMain.driveTrain.getLeftMotor2().getSpeed());
        SmartDashboard.putNumber("Right Motor 1: Speed: ", RobotMain.driveTrain.getRightMotor().getSpeed());
        SmartDashboard.putNumber("Right Motor 2: Speed: ", RobotMain.driveTrain.getRightMotor2().getSpeed());
        SmartDashboard.putNumber("Top Motor    : Speed: ", RobotMain.ballCaptureMechanism.getMotor().getSpeed());
        SmartDashboard.putNumber("Adjustment Value: ", Constants.ADJUSTMENT);
    }
    public static void updateDashboard(){
        SmartDashboard.putNumber("Right Joystick: Y-value ", OI.right_Joystick.getJoystick().getY());
        SmartDashboard.putNumber("Left Joystick: Y-value ", OI.left_Joystick.getJoystick().getY());
        SmartDashboard.putNumber("Left Motor 1 : Speed: ", RobotMain.driveTrain.getLeftMotor().getSpeed());
        SmartDashboard.putNumber("Left Motor 2 : Speed: ", RobotMain.driveTrain.getLeftMotor2().getSpeed());
        SmartDashboard.putNumber("Right Motor 1: Speed: ", RobotMain.driveTrain.getRightMotor().getSpeed());
        SmartDashboard.putNumber("Right Motor 2: Speed: ", RobotMain.driveTrain.getRightMotor2().getSpeed());
        SmartDashboard.putNumber("Top Motor    : Speed: ", RobotMain.ballCaptureMechanism.getMotor().getSpeed());
        SmartDashboard.putNumber("Adjustment Value: ", Constants.ADJUSTMENT);
        
    }
}
