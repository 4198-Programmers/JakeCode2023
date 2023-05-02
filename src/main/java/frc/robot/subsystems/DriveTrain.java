package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

    CANSparkMax FLMotor = new CANSparkMax(Constants.FLMOTOR_ID, MotorType.kBrushless);
    CANSparkMax FRMotor = new CANSparkMax(Constants.FRMOTOR_ID, MotorType.kBrushless);
    CANSparkMax BLMotor = new CANSparkMax(Constants.BLMOTOR_ID, MotorType.kBrushless);
    CANSparkMax BRMotor = new CANSparkMax(Constants.BRMOTOR_ID, MotorType.kBrushless);

    RelativeEncoder FLMEncoder = FLMotor.getEncoder();
    RelativeEncoder FRMEncoder = FLMotor.getEncoder();
    RelativeEncoder BLMEncoder = BLMotor.getEncoder();
    RelativeEncoder BRMEncoder = BRMotor.getEncoder();

    MotorControllerGroup LeftMotors = new MotorControllerGroup(FLMotor , BLMotor);
    MotorControllerGroup RightMotors = new MotorControllerGroup(FRMotor, BLMotor);

    DifferentialDrive allDrive = new DifferentialDrive(LeftMotors, RightMotors);
    
    public void drive(double zRotate, double xAxis){
        allDrive.arcadeDrive(Constants.DRIVE_SPEED * zRotate, Constants.DRIVE_SPEED * xAxis);
    }

    public void resetPosition(){
        FLMEncoder.setPosition(0d);
        FRMEncoder.setPosition(0d);
        BLMEncoder.setPosition(0d);
        BLMEncoder.setPosition(0d);
    }

    public double findPosition(){
       double encCurrentPosition = Math.abs(FLMEncoder.getPosition());
       encCurrentPosition += Math.abs(FRMEncoder.getPosition());
       encCurrentPosition += Math.abs(BLMEncoder.getPosition());
       encCurrentPosition += Math.abs(BRMEncoder.getPosition());
       return encCurrentPosition /4d;
    }

    public void setPosition(int i){

    }
}
