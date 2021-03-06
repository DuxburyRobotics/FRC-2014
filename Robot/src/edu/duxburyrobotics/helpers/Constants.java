/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.helpers;

/**
 *
 * @author Tate
 */
public class Constants {
    /* Button command constants */
    public static final int ACTION_PRESSED = 0;
    public static final int ACTION_RELEASED = 1;
    public static final int ACTION_HELD = 2;
    
    /* Device channels/ports */
    public static final int MOTOR_PORT_RIGHT1 = 1;
    public static final int MOTOR_PORT_LEFT1 = 2;
    public static final int MOTOR_PORT_RIGHT2 = 3;
    public static final int MOTOR_PORT_LEFT2 = 4;
    public static final int MOTOR_PORT_CAPTURE = 5;
    public static final int SOLENOID_PORT_FORWARD = 1;
    public static final int SOLENOID_PORT_REVERSE = 2;
    public static final int BACK_SOLENOID_PORT_FORWARD = 4;
    public static final int BACK_SOLENOID_PORT_BACKWARDS = 3 ;
    public static final int COMPRESSOR_PORT_SWITCH = 1; //Digital IO ports
    public static final int COMPRESSOR_PORT_RELAY = 1;  //Relay ports
    public static final int DETECTOR_PORT = 5;
    public static final int HATCH_PORT_FORWARD = 3;
    public static final int HATCH_PORT_REVERSE = 4;
    
    /* DriveTrain constants */
    public static final double DRIVE_SENSITIVITY = 0.2;
    public static final double DRIVE_MIN_POWER = 0.55;
    public static final double DRIVE_MAX_POWER = 1.0;
    public static final double DRIVE_TURN_MULTIPLIER = 0.8;
    public static final double DRIVE_BOOST = 1.5;
    public static double ADJUSTMENT = 0.14;
    
    /* Button index constants */
    public static final int BUTTON_SPEED_BOOST = 1;
    public static final int BUTTON_CAPTURE_BALL = 1;
    public static final int BUTTON_RELEASE_BALL = 2;
    public static final int BUTTON_TOGGLE_FRAME = 1;
    public static final int Button_Toggle_Back = 2;
    
    /* Timeout for the lifting and lowering of arms */
    public static final double ARM_MOVE_TIMEOUT = 1.5;
}
