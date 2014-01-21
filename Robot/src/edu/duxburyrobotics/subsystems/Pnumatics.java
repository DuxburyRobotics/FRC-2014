/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.io.OI;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Evan
 */


public class Pnumatics extends Subsystem{

    private boolean armsDown = false;
    
    private Compressor compressor;

    
    //********** IN CASE OF DOUBLE SOLENOIDS********
    private DoubleSolenoid leftDoubleSolenoid;
    private DoubleSolenoid rightDoubleSolenoid;
    //**********************************************
    public Pnumatics()
    {
     //TODO create objects of the solenoid and compressor
       
        compressor.start();
    }
    protected void initDefaultCommand() {
    }
    
    public void update()
    {
        //if button is clicked
        if (OI.right_Joystick.getButton(2).get())
        {
            if (isDown())
            {
                //call command group for rising..
            }
            else
            {
                //call command group for lowering..
            }
            
            
        }
    }
    
    public void extend()
    {
        //****** IN CASE OF 2 DOUBLE SOLENOIDS*********
        leftDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
        rightDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
        //*********************************************
        armsDown = false;
    }
    
    public void retract()
    {
        
        //****** IN CASE OF 2 DOUBLE SOLENOIDS*********
        leftDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        rightDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        //*********************************************
        
        armsDown = true;
    }
    
    public void stopMoving()
    {
        
        //****** IN CASE OF 2 DOUBLE SOLENOIDS*********
        leftDoubleSolenoid.set(DoubleSolenoid.Value.kOff);
        rightDoubleSolenoid.set(DoubleSolenoid.Value.kOff);
        //*********************************************
    }
    
    public boolean isDown()
    {
        return armsDown;
    }
    
}
