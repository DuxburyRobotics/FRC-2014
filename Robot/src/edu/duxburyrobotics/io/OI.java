
package edu.duxburyrobotics.io;

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
        right_Joystick.createButton(2);
        right_Joystick.createButton(1);
    }
    
    
    private static void initLeftStick(){
        left_Joystick = new Enjoystick(new Joystick(leftJoystickInputValue));
    }
}
