package OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Ben, Evan
 * 
 * Creates and init's Joysticks and their buttons
 */
public class Enjoystick {

    public static final int amountOfButtons = 20;
    
    private final Joystick joystick;
    private final JoystickButton[] buttons;
    
    public Enjoystick(Joystick joystick){
        this.joystick = joystick;
        buttons = new JoystickButton[amountOfButtons];
        //buttons = new Hashtable();
    }
    
    public Joystick getJoystick(){
        return joystick;
    }
    
    /**
     *getButton returns a button at a position. 
     * @param pos -the position of the button 0 - (amountOfButtons - 1)
     * @return -JoystickButton at the position requested
     */
    public JoystickButton getButton(int pos)
    {
        //if button is null inform us on console
        if(buttons[pos] == null)
        {
            System.err.println("Button " + pos + " is null");
            return null;
        }
    
        return buttons[pos];
    }
    
    /**
     * @param buttonNumber  -the number on the joystick refering to the button
     * @param command -the command you want the button to run
     * @param option -int 0 = whenPressed, 1 = whenReleased, 2 = whileHeld, default whileHeld
     * @param pos - defines where the button is stored in the internal array
     */
    public void createButton(int buttonNumber, int pos, Command command, int option){
        JoystickButton jb = new JoystickButton(joystick, buttonNumber);
        
        //assign the command to the button with appropriate action listener
        switch (option)
        {
            case 0:
                jb.whenPressed(command);
                break;
            case 1:
                jb.whenReleased(command);
                break;
            case 2:
                jb.whileHeld(command);
                break;
            default:
                jb.whileHeld(command);
                break;
        }
        checkCreation(pos);
        buttons[pos] = jb;
    }
    
    /**
     *  This method will cause logic error
     *  (example value pos = 1, trigger) it will assign the button correctly
     *  to the Joystick but on buttons[] it will be at index 1. being the lowest
     *  value button, the pos should be 0.
     * 
     * @param pos int value for the position of the button see logic error above
     */
    public void createButton(int pos){
        // if needed:
        //can catch several errorrs where Button is alredy created
        checkCreation(pos);
        buttons[pos] = new JoystickButton(joystick, pos);
     //buttons.put(pos,new JoystickButton(joystick, pos.intValue()));
    }
    public void createButton(int location,int pos){
        // if needed:
        //can catch several errorrs where Button is alredy created
        checkCreation(location);
        buttons[location] = new JoystickButton(joystick, pos);
     //buttons.put(pos,new JoystickButton(joystick, pos.intValue()));
    }
    public boolean checkCreation(int pos){
        //checks if button is going to be overwritten
        if(buttons[pos] != null){
            System.err.println("Overrides Button ...");
        }
        return true;
    }
    
}
