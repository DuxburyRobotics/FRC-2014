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
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Evan, Tate
 */

public class BallCaptureFrame extends Subsystem{

    private boolean _isFrameExtended = false;
    private final Compressor compressor;
    private final Relay solenoidController;
    
    /*
    private final DoubleSolenoid leftSolenoid;
    private DoubleSolenoid rightSolenoid = null;
    */
    private boolean usesSingleSolenoid = false;

    /**
     * @param sc Whether or not a single solenoid will be used
     */
    public BallCaptureFrame(final boolean sc) {
        usesSingleSolenoid = sc;
        compressor = new Compressor(Constants.COMPRESSOR_PORT_SWITCH, Constants.COMPRESSOR_PORT_SWITCH);
        
        solenoidController = new Relay(3, 1, Relay.Direction.kBoth);
        
        /*
        leftSolenoid = new DoubleSolenoid(Constants.SOLENOID_PORT_LEFT_FORWARD, Constants.SOLENOID_PORT_LEFT_REVERSE);
        if (!usesSingleSolenoid)
            rightSolenoid = new DoubleSolenoid(Constants.SOLENOID_PORT_RIGHT_FORWARD, Constants.SOLENOID_PORT_RIGHT_REVERSE);
        */
                
        compressor.start();
    }
    
    protected void initDefaultCommand() {}
    
    public void extend() {
        //leftSolenoid.set(DoubleSolenoid.Value.kForward);
        //rightSolenoid.set(DoubleSolenoid.Value.kForward);
        
        //setSolenoids(Value.kForward);
        
        setRelay(Relay.Value.kForward);
        _isFrameExtended = false;
    }
    
    public void retract() {
        //leftSolenoid.set(DoubleSolenoid.Value.kReverse);
        //rightSolenoid.set(DoubleSolenoid.Value.kReverse);
        
        //setSolenoids(Value.kReverse);
        
        setRelay(Relay.Value.kReverse);
        _isFrameExtended = true;
    }
    
    public void stopMoving() {
        //leftSolenoid.set(DoubleSolenoid.Value.kOff);
        //rightSolenoid.set(DoubleSolenoid.Value.kOff);
        
        //setSolenoids(Value.kOff);
        
        setRelay(Relay.Value.kOff);
    }
    
    private void setRelay(Relay.Value val) {
        solenoidController.set(val);
    }
    
    private void setSolenoids(Value val) {
        /*
        leftSolenoid.set(val);
        if (!usingSingleSolenoid())
            rightSolenoid.set(val);
        */
    }
    
    public boolean usingSingleSolenoid() {
        return usesSingleSolenoid;
    }
    
    public boolean isFrameExtended() {
        return _isFrameExtended;
    }
}
