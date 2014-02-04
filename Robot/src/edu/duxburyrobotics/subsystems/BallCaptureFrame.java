/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.commands.ToggleFrameCommand;
import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Evan, Tate
 */

public class BallCaptureFrame extends Subsystem{

    private boolean _isFrameExtended;
    private final Compressor compressor;
    private final DoubleSolenoid dasSolenoid;

    public BallCaptureFrame() {
        _isFrameExtended = false;
        compressor = new Compressor(Constants.COMPRESSOR_PORT_SWITCH, Constants.COMPRESSOR_PORT_RELAY);
        dasSolenoid = new DoubleSolenoid(Constants.SOLENOID_PORT_FORWARD, Constants.SOLENOID_PORT_REVERSE);
        
        //set the default frame to the toggle
        setDefaultCommand(new ToggleFrameCommand());
                
        compressor.start();
    }
    
    protected void initDefaultCommand() {}
    
    public void extend() {
        dasSolenoid.set(Value.kForward);
        _isFrameExtended = true;
    }
    
    public void retract() {
        dasSolenoid.set(Value.kReverse);
        _isFrameExtended = false;
    }
    
    public boolean isFrameExtended() {
        return _isFrameExtended;
    }
}
