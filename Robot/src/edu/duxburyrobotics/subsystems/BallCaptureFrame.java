/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Evan, Tate
 */

public class BallCaptureFrame extends Subsystem{

    private boolean _isFrameExtended;
    private final Compressor compressor;
    private final DoubleSolenoid leftSolenoid;
    private final DoubleSolenoid rightSolenoid;

    public BallCaptureFrame() {
        _isFrameExtended = false;
        compressor = new Compressor(1, 1); //TODO: these values need to be changed for actual values
        leftSolenoid = new DoubleSolenoid(4, 5); //TODO: these values must be verified as well
        rightSolenoid = new DoubleSolenoid(4, 5); //TODO: same with these        
        
        compressor.start();
    }
    
    protected void initDefaultCommand() {}
    
    public void update() {
        /* This shouldn't be handled in this class
        //if button is clicked
        if (OI.right_Joystick.getButton(2).get()) {
            if (_isFrameExtended) {
                //call command group for rising..
            } else {
                //call command group for lowering..
            }
        }
        */
    }
    
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
    
    public boolean isFrameExtended()
    {
        return _isFrameExtended;
    }
}
