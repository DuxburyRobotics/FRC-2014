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
    /* Device ports */
    public static final int MOTOR_PORT_LEFT1 = 2;
    public static final int MOTOR_PORT_RIGHT1 = 1;
    public static final int MOTOR_PORT_LEFT2 = 4;
    public static final int MOTOR_PORT_RIGHT2 = 3;
    public static final int MOTOR_PORT_CAPTURE = 5;
    
    /* DriveTrain constants */
    public static final double DRIVE_SENSITIVITY = 0.2;
    public static final double DRIVE_MIN_POWER = 0.55;
    public static final double DRIVE_MAX_POWER = 1.0;
    public static final double DRIVE_TURN_MULTIPLIER = 1.0;
    public static final double DRIVE_BOOST = 1.5;
    
    /* Button index constants */
    public static final int BUTTON_SPEED_BOOST = 1;
    public static final int BUTTON_CAPTURE_BALL = 1;
    public static final int BUTTON_RELEASE_BALL = 2;
    public static final int BUTTON_TOGGLE_FRAME = 1;
}
