package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.controller.PIDFController;

import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Utility.k;

public class DriveDefaultCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveSubsystem m_driveSubsystem;
    CommandOpMode m_opMode;

    double x,y,z, ang;

    public DriveDefaultCommand(CommandOpMode _opMode, DriveSubsystem _driveSubsystem){
        m_driveSubsystem = _driveSubsystem;
        m_opMode = _opMode;
        addRequirements(m_driveSubsystem);
    }
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        y = -Hw.gpDriver.getLeftY();
        x = -Hw.gpDriver.getLeftX();
        z = -Hw.gpDriver.getRightX();

        z = z * k.DRIVE.RotationScale;

        ang = -Hw.imu.getAbsoluteHeading();
        m_driveSubsystem.driveCartesianIK(y,x,z,ang);
        PIDFController f;

    }
}
