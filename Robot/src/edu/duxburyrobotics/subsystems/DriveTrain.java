
package edu.duxburyrobotics.subsystems;

import edu.duxburyrobotics.commands.DriveCommand;
import edu.duxburyrobotics.helpers.Constants;
import edu.duxburyrobotics.io.OI;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Ben, Tate, Evan
 * Creates a subclass of RobotDrive to specify our RobotDrive
 */
public class DriveTrain extends Subsystem{
    
    private final RobotDrive roboDriveTrain;
    public static Jaguar rightMotor1;
    public static Jaguar leftMotor1;
    public static Victor rightMotor2;
    public static Jaguar leftMotor2;
    private double desiredVelocity;
    private double currentVelocity;
    
    public DriveTrain(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor) {
        roboDriveTrain = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    }
    
    public DriveTrain(){
       rightMotor1 = new Jaguar(1, Constants.MOTOR_PORT_RIGHT1);
       leftMotor1 = new Jaguar(1, Constants.MOTOR_PORT_LEFT1);
       rightMotor2 = new Victor(1, Constants.MOTOR_PORT_RIGHT2);
       leftMotor2 = new Jaguar(1, Constants.MOTOR_PORT_LEFT2);
    
        roboDriveTrain = new RobotDrive(leftMotor1, leftMotor2, rightMotor1, rightMotor2);
        roboDriveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        roboDriveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        roboDriveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        roboDriveTrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        roboDriveTrain.setMaxOutput(Constants.DRIVE_MAX_POWER);
        roboDriveTrain.setSensitivity(Constants.DRIVE_SENSITIVITY);
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }
    
    /**
     * This method should use the twist value of the joystick for turning
     * and use the throttle to control it's speed.
     * 
     * @param stick Joystick to take input from
     * @param boost Whether or not to engage maximum speed and ignore throttle speed
     */
    public void twistThrottleDrive(final Joystick stick, final boolean boost) {
        double newData = 1.0; 
        
        if(!boost){
            double throttleData = (stick.getThrottle() * -1.0 + 1.0) / 2.0;
            newData =  (((throttleData) * (1.0 - Constants.DRIVE_MIN_POWER)) / 1.0) + Constants.DRIVE_MIN_POWER; //Don't touch, magic ahead.
        }
        
        double driveSpeed = stick.getY() * newData;// * -1.0;
        double turnSpeed = stick.getTwist() * newData * Constants.DRIVE_TURN_MULTIPLIER;// * -1.0;
        
        if (Math.abs(turnSpeed) <= 0.07f){
        //if(!(turnSpeed >= 0-Constants.ADJUSTMENT && turnSpeed <= )){
            turnSpeed += Constants.ADJUSTMENT; 
        }
        
        roboDriveTrain.arcadeDrive(driveSpeed, turnSpeed);
    }
    
    /**
     * Same as the twist drive, except there is no concept of a boost, maximum 
     * speed is engaged at all times. Also, there is minor correction for Tate
     * Spazz mode.
     */
    public void eliteDrive() {
        final Joystick stick = OI.right_Joystick.getJoystick();
        
        final double driveSpeed = stick.getY();
        double turnSpeed = stick.getTwist() * Constants.DRIVE_TURN_MULTIPLIER;
        
        if (Math.abs(turnSpeed) <= 0.07)
            turnSpeed += Constants.ADJUSTMENT;
        
        desiredVelocity = driveSpeed;
        if (desiredVelocity > currentVelocity)
            currentVelocity += 0.1;
        else if (desiredVelocity < currentVelocity)
            currentVelocity -= 0.1;
        
        if (currentVelocity > 1.0)
            currentVelocity = 1.0;
        else if (currentVelocity < -1.0)
            currentVelocity = -1.0;
        
        roboDriveTrain.arcadeDrive(currentVelocity, turnSpeed);
    }
    
    /**
     * This method should be called to drive if the user wants the choice
     * between twist turning and x-axis turning. x-axis turning sucks and Piers 
     * is a silly goose that doesn't know what he's talking about, so 
     * hopefully this is just for debug...
     */
    public void driveDebug(){
        if (OI.right_Joystick.getButton(2).get())       
            roboDriveTrain.arcadeDrive(OI.right_Joystick.getJoystick());
        else
            twistThrottleDrive(OI.right_Joystick.getJoystick(), OI.right_Joystick.getButton(1).get());
    }
    
    /**
     * Method to call when driving autonomously. Nicely 
     * wraps the drive() method
     *
     * @param power Value from -1.0 to 1.0 to control the speed of the motor
     */
    public void autonomousDrive(final double power) {
        roboDriveTrain.drive(power, Constants.ADJUSTMENT * 0.4);
    }
    
    /**
     * Convenience method to stop the motors from turning
     */
    public void stopDriving() {
        roboDriveTrain.drive(0.0, 0.0);
    }
    
    public void superdrive(){
        //This method must never be deleted!
        //Doing so will break the entire program!
    }
    
    public RobotDrive getDrive(){
        return roboDriveTrain;
    }
    
    public Jaguar getRightMotor(){
        return rightMotor1;
    }
    
    public Victor getRightMotor2(){
        return rightMotor2;
    }
    
    public Jaguar getLeftMotor(){
        return leftMotor1;
    }
    
    public Jaguar getLeftMotor2(){
        return leftMotor2;
    }
    
}
