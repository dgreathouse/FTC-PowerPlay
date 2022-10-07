package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.PIDFController;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Utility.MyMath;
import org.firstinspires.ftc.teamcode.Utility.k;

public class DriveAutoRotateCommand extends CommandBase {

    CommandOpMode m_opMode;
    DriveSubsystem m_drive;
    double m_angle;
    double m_timeOut;
    double m_maxSpeed;
    PIDFController m_pidfRotation;
    ElapsedTime m_elapsedTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    ElapsedTime m_pidTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    double m_pidRotateOutput = 0;
    public DriveAutoRotateCommand(CommandOpMode _opMode, DriveSubsystem _drive, double _angle, double _maxSpeed, double _timeOut){
        m_opMode = _opMode;
        m_drive = _drive;
        m_angle = _angle;
        m_timeOut = _timeOut;
        m_maxSpeed = _maxSpeed;
    }
    @Override
    public void initialize(){
        m_pidfRotation = new PIDFController(k.DRIVE.RotatePIDFCoef);
        m_pidfRotation.setOutputRange(0,m_maxSpeed);
        m_pidfRotation.setSetpoint(m_angle);
        m_pidfRotation.setInputRange(0,m_angle*2);
        m_pidfRotation.setIntegralRange(-0.2, 0.2);
        m_pidfRotation.setTolerance(1);
        m_pidTimer.reset();
    }
    @Override
    public void execute(){
        m_pidRotateOutput = m_pidfRotation.performPID(Hw.imu.getAbsoluteHeading());
        m_pidRotateOutput = MyMath.clamp(m_pidRotateOutput,-m_maxSpeed, m_maxSpeed);
        m_drive.driveCartesianIK(0,0,m_pidRotateOutput,0);
        while(m_pidTimer.seconds() < 0.05){}
        m_pidTimer.reset();
    }
    @Override
    public boolean isFinished(){
        if(!m_pidfRotation.onTarget(4) || m_elapsedTimer.seconds() < m_timeOut){
            return true;
        }
        return false;
    }
}
