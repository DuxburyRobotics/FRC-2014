/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.duxburyrobotics.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author Ben
 * creates an subClass of Robotdrive to specifie our RobotDrive
 */
public class DriveTrain extends RobotDrive{

    public DriveTrain(SpeedController leftMotor, SpeedController rightMotor) {
        super(leftMotor, rightMotor);
    }
    
    public void superdrive(){
        //SUPER AWESOME DRIVING METHODE HERE
    }
}
