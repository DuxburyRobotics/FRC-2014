/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.helpers.Constants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Evan, Tate
 */

public class BallCaptureFrame extends Subsystem{

    private boolean _isFrameExtended;
    //private final Compressor compressor;
    private final DoubleSolenoid leftSolenoid;
    private final DoubleSolenoid rightSolenoid;

    public BallCaptureFrame() {
        _isFrameExtended = false;
        //compressor = new Compressor(Constants.COMPRESSOR_PORT_SWITCH, Constants.COMPRESSOR_PORT_SWITCH);
        leftSolenoid = new DoubleSolenoid(Constants.SOLENOID_PORT_LEFT_FORWARD, Constants.SOLENOID_PORT_LEFT_REVERSE);
        rightSolenoid = new DoubleSolenoid(Constants.SOLENOID_PORT_RIGHT_FORWARD, Constants.SOLENOID_PORT_RIGHT_REVERSE);
        
        //compressor.start();
    }
    
    protected void initDefaultCommand() {}
    
    public void extend() {
        leftSolenoid.set(DoubleSolenoid.Value.kForward);
        rightSolenoid.set(DoubleSolenoid.Value.kForward);
        _isFrameExtended = false;
    }
    
    public void retract() {
        leftSolenoid.set(DoubleSolenoid.Value.kReverse);
        rightSolenoid.set(DoubleSolenoid.Value.kReverse);        
        _isFrameExtended = true;
    }
    
    public void stopMoving() {
        leftSolenoid.set(DoubleSolenoid.Value.kOff);
        rightSolenoid.set(DoubleSolenoid.Value.kOff);
    }
    
    public boolean isFrameExtended() {
        return _isFrameExtended;
    }
}
