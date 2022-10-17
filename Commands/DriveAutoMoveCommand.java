package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Utility.PIDFController;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Utility.DAngle;
import org.firstinspires.ftc.teamcode.Utility.MyMath;
import org.firstinspires.ftc.teamcode.Utility.k;

public class DriveAutoMoveCommand extends CommandBase {

    CommandOpMode m_opMode;
    DriveSubsystem m_drive;
    DAngle m_angle;
    double m_inches;
    double m_timeOut;
    double m_maxSpeed;

    PIDFController m_pidfMove;
    ElapsedTime m_elapsedTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    ElapsedTime m_pidTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

    double m_pidDriveOutput = 0.0;

    public DriveAutoMoveCommand(CommandOpMode _opMode, DriveSubsystem _drive, DAngle _angle, double _maxSpeed, double _inches, double _timeOut){
        m_opMode = _opMode;
        m_drive = _drive;
        m_angle = _angle;
        m_inches = _inches;
        m_timeOut = _timeOut;
        m_maxSpeed = _maxSpeed;
    }
    @Override
    public void initialize(){
        m_pidfMove = new PIDFController(k.DRIVE.MovePIDFCoef);
        m_pidfMove.setOutputRange(0,m_maxSpeed);
        m_pidfMove.setSetpoint(m_inches);
        m_pidfMove.setInputRange(0,m_inches*2);
        m_pidfMove.setIntegralRange(-0.3, 0.3);
        m_pidfMove.setTolerance(0.5);
        m_drive.resetMotors();
        m_pidfMove.enable();
        m_elapsedTimer.reset();
        m_pidTimer.reset();
    }
    @Override
    public void execute(){
        m_pidDriveOutput = m_pidfMove.performPID(m_drive.getInchesDriven(m_angle));
        m_pidDriveOutput = MyMath.clamp(m_pidDriveOutput,-m_maxSpeed, m_maxSpeed);
        double x = m_pidDriveOutput * Math.sin(Math.toRadians(m_drive.getAngle(m_angle)));
        double y = m_pidDriveOutput * Math.cos(Math.toRadians(m_drive.getAngle(m_angle)));
        m_drive.driveCartesianIK(-y,-x,0,0);
        while(m_pidTimer.seconds() < 0.05){}
        m_pidTimer.reset();
    }
    @Override
    public boolean isFinished(){
        if(m_pidfMove.onTarget(4) || m_elapsedTimer.seconds() > m_timeOut){
            m_drive.driveCartesianIK(0,0,0,0);
            return true;
        }
        return false;
    }
}
