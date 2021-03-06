/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Evan, Tate
 */

public class BallCaptureFrame extends Subsystem {

    private boolean frameExtended;
    private final Compressor compressor;
    private final DoubleSolenoid frameController;

    public BallCaptureFrame() {
        frameExtended = false;
        
        compressor = new Compressor(Constants.COMPRESSOR_PORT_SWITCH, Constants.COMPRESSOR_PORT_RELAY);
        frameController = new DoubleSolenoid(Constants.SOLENOID_PORT_FORWARD, Constants.SOLENOID_PORT_REVERSE);
        
        frameController.set(Value.kReverse);
        compressor.start();
    }
    
    protected void initDefaultCommand() { }
    
    /**
     * Extends the pneumatic pistons
     */
    public void extend() {
        frameController.set(DoubleSolenoid.Value.kForward);
        frameExtended = true;
    }
    
    /**
     * Retracts the pneumatic pistons
     */
    public void retract() {
        frameController.set(DoubleSolenoid.Value.kReverse);
        frameExtended = false;
    }
    
    /**
     * Whether or not the pneumatic pistons are extended
     * 
     * @return boolean
     */
    public boolean isFrameExtended() {
        return frameExtended;
    }
}
