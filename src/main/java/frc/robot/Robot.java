package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
//navx imports
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DriverStation;

//spark maxes/neos imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//regular imports
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

//vision imports
import RIO.java.src.org.team5109.frc.networktables.*;


//Robot start
public class Robot extends TimedRobot{

  //navX
  AHRS navX;

  //joysticks
  public Joystick leftJoystick = new Joystick(0);
  public Joystick rightJoystick = new Joystick(1);
  public Joystick operator = new Joystick(2);


  //pid Values
  public double kP; 
  public double kI;
  public double kD; 
  public double kIz; 
  public double kFF;
  public double kMaxOutput;
  public double kMinOutput;
  public double maxRPM; 
  public double setpoint;
  public double desiredSetPoint;
  public double centerX;
  public double distance;
  public double tuningConstant;
  public double pixoff;
  public double direction;
  public double setPoint;
  public double maxVel, minVel, maxAcc, allowedErrLeft, allowedErrRight;



  //vision
  imudata ntwrk = new imudata();
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private SendableChooser<String> m_chooser = new SendableChooser<>();
  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable visiontable;

  //gear switching booleans
  public boolean lowGear = true;
  public boolean changeGears = true;

  //arcadeDrive switching
  public boolean squaredInput = false;
  public boolean changeDrive = true;

  //Neos plus respective encoders and pidcontrollers
  private CANSparkMax leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
  private CANEncoder leftEncoder1 = leftMotor1.getEncoder();
  private CANPIDController leftPidController1 = leftMotor1.getPIDController();
  private CANSparkMax leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);
  private CANEncoder leftEncoder2 = leftMotor2.getEncoder();
  private CANPIDController leftPidController2 = leftMotor2.getPIDController();
  private CANSparkMax leftElevator = new CANSparkMax(3, MotorType.kBrushless);
  private CANEncoder leftElevatorEncoder = leftElevator.getEncoder();
  private CANPIDController leftElevatorPidController = leftElevator.getPIDController();
  private CANSparkMax rightMotor1 = new CANSparkMax(4, MotorType.kBrushless);
  private CANEncoder rightEncoder1 = rightMotor1.getEncoder();
  private CANPIDController rightPidController1 = rightMotor1.getPIDController();
  private CANSparkMax rightMotor2 = new CANSparkMax(5, MotorType.kBrushless);
  private CANEncoder rightEncoder2 = rightMotor2.getEncoder();
  private CANPIDController rightPidController2 = rightMotor2.getPIDController();
  private CANSparkMax rightElevator = new CANSparkMax(6, MotorType.kBrushless);
  private CANEncoder rightElevatorEncoder = rightElevator.getEncoder();
  private CANPIDController rightElevatorPidController = rightElevator.getPIDController();

  //elevator encoder counts
  private double elevatorEncoderCounts = 0;
  
  //SpeedControl
  private DifferentialDrive m_myRobot;

  SpeedControllerGroup m_left;
  SpeedControllerGroup m_right;

  //robotInit Start
  @Override
  public void robotInit() {
  rightMotor1.setInverted(true);
  rightMotor2.setInverted(true);
  leftMotor1.setInverted(true);
  leftMotor2.setInverted(true);

  m_left = new SpeedControllerGroup(leftMotor1, leftMotor2);
  m_right = new SpeedControllerGroup(rightMotor1, rightMotor2);



    //vision init
    m_chooser.addDefault("Default Auto", kDefaultAuto);
    m_chooser.addObject("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto Choices", m_chooser);


  }
  //robotInit End

  public void autonomousInit() {

    leftEncoder1.setPosition(0);
    leftEncoder2.setPosition(0);
    rightEncoder1.setPosition(0);
    rightEncoder2.setPosition(0);
  
    m_myRobot = new DifferentialDrive(m_left, m_right);

    m_myRobot.setSafetyEnabled(false);
      kP = .0000007;
      kI = 0;
      kD = 1; 
      kIz = 0; 
      kFF = .0002;
    kMaxOutput = 1; 
    kMinOutput = -1;
    maxRPM = 5700;

    maxVel = 7000;

    maxAcc = 1000;

    allowedErrLeft = 0;
    allowedErrRight = 0;

    leftMotor1.setClosedLoopRampRate(1);
    rightMotor1.setClosedLoopRampRate(1);
    leftMotor2.setClosedLoopRampRate(1);
    rightMotor2.setClosedLoopRampRate(1);

    int smartMotionSlot = 0; // same gains for both sides, otherwise set 0-3

     leftPidController1.setP(kP);
     leftPidController1.setI(kI);
     leftPidController1.setD(kD);
     leftPidController1.setIZone(kIz);
     leftPidController1.setFF(kFF);
     leftPidController1.setOutputRange(kMinOutput, kMaxOutput);
     /*leftPidController1.setSmartMotionMaxVelocity(maxVel, smartMotionSlot);
     leftPidController1.setSmartMotionMinOutputVelocity(minVel, smartMotionSlot);
     leftPidController1.setSmartMotionMaxAccel(maxAcc, smartMotionSlot);
     leftPidController1.setSmartMotionAllowedClosedLoopError(allowedErrLeft, smartMotionSlot);
     */leftPidController2.setP(kP);
     leftPidController2.setI(kI);
     leftPidController2.setD(kD);
     leftPidController2.setIZone(kIz);
     leftPidController2.setFF(kFF);
     leftPidController2.setOutputRange(kMinOutput, kMaxOutput);
     /*leftPidController2.setSmartMotionMaxVelocity(maxVel, smartMotionSlot);
     leftPidController2.setSmartMotionMinOutputVelocity(minVel, smartMotionSlot);
     leftPidController2.setSmartMotionMaxAccel(maxAcc, smartMotionSlot);
     leftPidController2.setSmartMotionAllowedClosedLoopError(allowedErrLeft, smartMotionSlot);
     *///and right
     rightPidController1.setP(kP);
     rightPidController1.setI(kI);
     rightPidController1.setD(kD);
     rightPidController1.setIZone(kIz);
     rightPidController1.setFF(kFF);
     rightPidController1.setOutputRange(kMinOutput, kMaxOutput);
     /*rightPidController1.setSmartMotionMaxVelocity(maxVel, smartMotionSlot);
     rightPidController1.setSmartMotionMinOutputVelocity(minVel, smartMotionSlot);
     rightPidController1.setSmartMotionMaxAccel(maxAcc, smartMotionSlot);
     rightPidController1.setSmartMotionAllowedClosedLoopError(allowedErrRight, smartMotionSlot);
     */rightPidController2.setP(kP);
     rightPidController2.setI(kI);
     rightPidController2.setD(kD);
     rightPidController2.setIZone(kIz);
     rightPidController2.setFF(kFF);
     rightPidController2.setOutputRange(kMinOutput, kMaxOutput);
     /*rightPidController2.setSmartMotionMaxVelocity(maxVel, smartMotionSlot);
     rightPidController2.setSmartMotionMinOutputVelocity(minVel, smartMotionSlot);
     rightPidController2.setSmartMotionMaxAccel(maxAcc, smartMotionSlot);
     rightPidController2.setSmartMotionAllowedClosedLoopError(allowedErrRight, smartMotionSlot);
    */
     SmartDashboard.putNumber("P Gain", kP);
     SmartDashboard.putNumber("I Gain", kI);
     SmartDashboard.putNumber("D Gain", kD);
     SmartDashboard.putNumber("I Zone", kIz);
     SmartDashboard.putNumber("Feed Forward", kFF);
     SmartDashboard.putNumber("Max Output", kMaxOutput);
     SmartDashboard.putNumber("Min Output", kMinOutput);

     // also display smart motion
         // display Smart Motion coefficients
     SmartDashboard.putNumber("Max Velocity", maxVel);
     SmartDashboard.putNumber("Min Velocity", minVel);
     SmartDashboard.putNumber("Max Acceleration", maxAcc);
     SmartDashboard.putNumber("Allowed Closed Loop Error Left", allowedErrLeft);
     SmartDashboard.putNumber("Allowed Closed Loop Error Right", allowedErrRight);
     SmartDashboard.putNumber("Set Position", 0);
     SmartDashboard.putNumber("Set Velocity", 0); 


  }

  public void autonomousPeriodic() {
    if (leftJoystick.getRawButton(1)){
      double setPoint = 500;
      /**
       * Note that left is set to the negative setpoint, because 
       * it's facing backwards
       */
      
      leftPidController1.setReference(-setPoint, ControlType.kVelocity);
      rightPidController1.setReference(setPoint, ControlType.kVelocity); 
      leftPidController2.setReference(-setPoint, ControlType.kVelocity);
      rightPidController2.setReference(setPoint, ControlType.kVelocity);

      /*leftPidController1.setReference(-setPoint, ControlType.kPosition);
      rightPidController1.setReference(setPoint, ControlType.kPosition); 
      leftPidController2.setReference(-setPoint, ControlType.kPosition);
      rightPidController2.setReference(setPoint, ControlType.kPosition);
     */

    
      SmartDashboard.putNumber("SetPoint", setPoint);
      SmartDashboard.putNumber("Left Encoder Position1", leftEncoder1.getPosition());
      SmartDashboard.putNumber("Left Encoder Position2", leftEncoder2.getPosition());
      SmartDashboard.putNumber("Right Encoder Position1", rightEncoder1.getPosition());
      SmartDashboard.putNumber("Right Encoder Position2", rightEncoder1.getPosition());
      SmartDashboard.putNumber("Left Encoder Velocity1", leftEncoder1.getVelocity());
      SmartDashboard.putNumber("Right Encoder Velocity1", rightEncoder1.getVelocity());
      SmartDashboard.putNumber("Left Encoder Velocity2", leftEncoder2.getVelocity());
      SmartDashboard.putNumber("Right Encoder Velocity2", rightEncoder2.getVelocity());
      
    }
    else {


      if(leftJoystick.getRawButton(11) && changeDrive){
        if(squaredInput){
          squaredInput = false;
          changeDrive = false;
        }
        else{
          squaredInput = true;
          changeDrive = false;
        }
      }
      else if(!leftJoystick.getRawButton(11)){
        changeDrive = true;
      }
   



 m_myRobot.arcadeDrive(leftJoystick.getY(),  -leftJoystick.getZ() * .5, squaredInput);
    

    /**
     * lets get some information up on the dash
     */
    SmartDashboard.putBoolean("squaredInput", squaredInput);


    /**
     * Just for tuning, let's print the joystick value as well.  This will help
     * establish our feed forward value
     */

  }
}
  }




