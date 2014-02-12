/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Evan
 */
public class BackDrop extends Subsystem{
    
    private final DoubleSolenoid solenoid;
    private boolean dropped;
    public BackDrop(){
        solenoid = new DoubleSolenoid(Constants.BACK_SOLENOID_PORT_FORWARD, Constants.BACK_SOLENOID_PORT_BACKWARDS);
        dropped = false;
    }

    protected void initDefaultCommand() {
    }
    
    /**
     * extends the solenoid forwards effectivly dropping the back
     * ball holding metal thing of the robot
     */
    public void dropDaBack(){
        solenoid.set(DoubleSolenoid.Value.kForward);
        dropped = true;
    }
    
    /**
     * extends the solenoid backwards effectivly dropping the back
     * ball holding metal thing of the robot
     */
    public void LiftDaBack(){
        solenoid.set(DoubleSolenoid.Value.kReverse);
        dropped = false;
    }
    
    public boolean isDropped(){
        return dropped;
    }
    
    
    
}
