package frc.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
//Latest code as of 4/11/18
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
  TalonSRX leftMotor1 = new TalonSRX(6); // 6, 10, 5, 4
  TalonSRX leftMotor2 = new TalonSRX(5);
  TalonSRX rightMotor1 = new TalonSRX(4);// 10
  TalonSRX rightMotor2 = new TalonSRX(8);// 10
  TalonSRX rightElevatorMotor = new TalonSRX(2);
  TalonSRX leftElevatorMotor = new TalonSRX(1);
	Joystick leftJoy = new Joystick( 0);
	Joystick rightJoy = new Joystick(1);
	Joystick operator = new Joystick(2);
    Encoder rightEncoder = new Encoder(6, 7, true); //true
    Encoder leftEncoder = new Encoder(8, 9, false); //false
 


    
    
    @Override
    public void robotInit() {
	 
    }

    
    @Override
    public void autonomousInit() {

   	    }  
    public void autonomousPeriodic() {
      
    }
  	 
    
    @Override
    public void teleopInit() {
    	
   		 }    

    public void teleopPeriodic() {	                                                                              
      
    }

    @Override
    public void testInit() {    
    
    }


    public void testPeriodic() {
        }
      

  
}




