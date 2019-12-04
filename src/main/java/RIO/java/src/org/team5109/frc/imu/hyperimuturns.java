package RIO.java.src.org.team5109.frc.imu;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import RIO.java.src.org.team5109.frc.datafromandroid.*;
public class hyperimuturns{
    hyperimu himu = new hyperimu();
    TalonSRX leftMotor1 =  new TalonSRX(6); //6, 10, 5, 4
    TalonSRX leftMotor2 =  new TalonSRX(10);
    TalonSRX rightMotor1 =  new TalonSRX(5);//10
    TalonSRX rightMotor2 =  new TalonSRX(4);//10

    public void right(){
    himu.receive();
    double yaw = himu.send_data();
    if (yaw < 180  && yaw > 90) {
        rightMotor1.set(ControlMode.PercentOutput, .2);
        rightMotor2.set(ControlMode.PercentOutput, .2);
        leftMotor1.set(ControlMode.PercentOutput, .2);
        leftMotor2.set(ControlMode.PercentOutput, .2);
    }
    else{
        rightMotor1.set(ControlMode.PercentOutput, 0);
        rightMotor2.set(ControlMode.PercentOutput, 0);
        leftMotor1.set(ControlMode.PercentOutput, 0);
        leftMotor2.set(ControlMode.PercentOutput, 0);
    }
}
}
