
package edu.duxburyrobotics.io;

import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.Joystick;

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
    }
    
    private static void initRightStick(){
        right_Joystick = new Enjoystick(new Joystick(rightJoystickInputValue));
        right_Joystick.createButton(Constants.BUTTON_SPEED_BOOST);
        right_Joystick.createButton(Constants.BUTTON_TOGGLE_FRAME);
    }
    
    
    private static void initLeftStick(){
        left_Joystick = new Enjoystick(new Joystick(leftJoystickInputValue));
        left_Joystick.createButton(Constants.BUTTON_CAPTURE_BALL);
        left_Joystick.createButton(Constants.BUTTON_RELEASE_BALL);
    }
}
