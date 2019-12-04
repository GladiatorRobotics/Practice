package RIO.java.src.org.team5109.frc.motor.encoders;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DriverStation;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.DriverStation;
import com.ctre.phoenix.motorcontrol.can.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class encodermotorcontrol {
    TalonSRX leftMotor1 =  new TalonSRX(6); //6, 10, 5, 4
    TalonSRX leftMotor2 =  new TalonSRX(10);
    TalonSRX rightMotor1 =  new TalonSRX(5);//10
    TalonSRX rightMotor2 =  new TalonSRX(4);//10  
    /*Encoder rightEncoder = new Encoder(0, 1, true); //true
    Encoder leftEncoder = new Encoder(8, 9, false); //false
    double  leftspeed = 0;
	double rightspeed = 0;
	long idealright = 0;
	long idealleft = 0;
    int Counter = 0;
    
    
    public void leftTurn(double degrees, double speed) { //degrees should be in degrees, basically out of 360
        long leftCount = leftEncoder.get();
        long rightCount = rightEncoder.get();
        double distanceR = 15*degrees;
        double distanceL = -15*degrees;
        if(rightCount <= distanceR || leftCount>= distanceL) {
            leftMotor1.set(ControlMode.PercentOutput, speed);
            leftMotor2.set(ControlMode.PercentOutput, speed);
            rightMotor1.set(ControlMode.PercentOutput, speed);
            rightMotor2.set(ControlMode.PercentOutput, speed);
        }
        else {
        leftEncoder.reset();
        rightEncoder.reset();
        leftMotor1.set(ControlMode.PercentOutput, 0);
        leftMotor2.set(ControlMode.PercentOutput, 0);
        rightMotor1.set(ControlMode.PercentOutput, 0);
        rightMotor2.set(ControlMode.PercentOutput, 0);
        Counter ++;
    
            
        }
    }
    public void rightTurn(double degrees, double speed) { //degrees should be in degrees, basically out of 360, speed is percent power of the motors
        long leftCount = leftEncoder.get();
        long rightCount = rightEncoder.get();
        double distanceL = 15*degrees;
        double distanceR = -15*degrees;
        if(leftCount <= distanceL || rightCount>= distanceR) {
            leftMotor1.set(ControlMode.PercentOutput, -speed);
            leftMotor2.set(ControlMode.PercentOutput, -speed);
            rightMotor1.set(ControlMode.PercentOutput, -speed);
            rightMotor2.set(ControlMode.PercentOutput, -speed);
        }
        else {
        leftEncoder.reset();
        rightEncoder.reset();
        leftMotor1.set(ControlMode.PercentOutput, 0);
        leftMotor2.set(ControlMode.PercentOutput, 0);
        rightMotor1.set(ControlMode.PercentOutput, 0);
        rightMotor2.set(ControlMode.PercentOutput, 0);
        Counter ++;
    
            
        }
}
public void driveStraight(double distance, int speed) {   //distance should be in feet, speed should be in encoder counts per cycle (40 is our base)
	double encoder_counts = distance * 1564.556753;
	double Acceleration = 0.03;
	long leftCount = leftEncoder.get();
	long rightCount = rightEncoder.get();
	long leftChange = leftCount - idealleft;
	long rightChange = rightCount - idealright;
	idealleft = leftEncoder.get();
	idealright = rightEncoder.get();
		if(leftCount <= encoder_counts && rightCount < encoder_counts) {	
			if (leftChange == speed) {
			}
			else if (leftChange >= speed) {
				leftspeed = leftspeed - Acceleration;
			}
			else if (leftChange <= speed) {
				leftspeed = leftspeed + Acceleration;	
			}
			if (rightChange == speed) {
			}
			else if (rightChange >= speed) {
				rightspeed = rightspeed - Acceleration;
			}
			else if (rightChange <= speed) {
				rightspeed = rightspeed + Acceleration;	
			}
			if (leftspeed >= 0.7) {
				leftspeed = 0.7;
			}
			if (rightspeed >= 0.7) {
				rightspeed = 0.7;
			}
			leftMotor1.set(ControlMode.PercentOutput, -leftspeed);
			leftMotor2.set(ControlMode.PercentOutput, -leftspeed);
			rightMotor1.set(ControlMode.PercentOutput, rightspeed);
			rightMotor2.set(ControlMode.PercentOutput, rightspeed);
			 
		}
		else {
			leftMotor1.set(ControlMode.PercentOutput, 0);
			leftMotor2.set(ControlMode.PercentOutput, 0);
			rightMotor1.set(ControlMode.PercentOutput, 0);
			rightMotor2.set(ControlMode.PercentOutput, 0);
			leftEncoder.reset();
			rightEncoder.reset();
			Counter ++;
		}
	
	  }

*/
}
