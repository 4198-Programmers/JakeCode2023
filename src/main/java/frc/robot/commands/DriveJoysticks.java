package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveJoysticks extends CommandBase{
    Joystick straight;
    Joystick sidetoside;
    DriveTrain drive;

    public DriveJoysticks(Joystick straight, Joystick sidetoside, DriveTrain drive){
        this.straight = straight;
        this.sidetoside = sidetoside;
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.drive(sidetoside.getRawAxis(0), straight.getRawAxis(1));
    }
}
