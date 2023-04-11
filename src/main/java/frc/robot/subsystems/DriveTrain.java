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

    DifferentialDrive drive = new DifferentialDrive(LeftMotors, RightMotors);
    
    public void arcadeDrive(double xSpeed, double zRotation){
        arcadeDrive(xSpeed, zRotation);
    }

    public double getPosition(){

    }
}
