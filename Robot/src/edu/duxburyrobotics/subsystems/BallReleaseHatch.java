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
 * @author Tate
 */
public class BallReleaseHatch extends Subsystem {

    private final DoubleSolenoid hatchController;
    private boolean hatchOpen;
    
    public BallReleaseHatch() {
        hatchController = new DoubleSolenoid(Constants.HATCH_PORT_FORWARD, Constants.HATCH_PORT_REVERSE);
        hatchOpen = false;
    }
    
    protected void initDefaultCommand() {}
    
    public void openHatch() {
        hatchController.set(DoubleSolenoid.Value.kForward);
        hatchOpen = true;
    }
    
    public void closeHatch() {
        hatchController.set(DoubleSolenoid.Value.kReverse);
        hatchOpen = false;
    }
    
    public boolean isHatchOpen() {
        return hatchOpen;
    }
}
