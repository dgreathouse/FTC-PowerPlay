package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.MyMath;
import org.firstinspires.ftc.teamcode.Utility.PIDFController;
import org.firstinspires.ftc.teamcode.Utility.k;

public class LiftAutoMoveCommand extends CommandBase {
    LiftSubsystem m_lift;
    CommandOpMode m_opMode;
    double m_inches;
    PIDFController m_pid;
    double m_timeOut;
    double m_speed;
    ElapsedTime m_elapsedTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    public LiftAutoMoveCommand(CommandOpMode _opMode, LiftSubsystem _lift, double _inches, double _speed, double _timeOut){
        addRequirements(_lift);
        m_lift = _lift;
        m_opMode = _opMode;
        m_inches = _inches;
        m_speed = _speed;
        m_timeOut = _timeOut;
        m_elapsedTimer.reset();
    }
    @Override
    public void initialize(){
        m_pid = new PIDFController(0.2,0.0,0.0,0.0);
        m_pid.setTolerance(.5);
        m_pid.setOutputRange(0.0, 0.7);
        m_pid.setInputRange(0,33);
        m_pid.setSetpoint(m_inches);
        m_pid.enable();
        m_elapsedTimer.reset();
    }
    @Override
    public void execute(){
        double out = m_pid.performPID(Hw.lift.getDistance());
        out = MyMath.clamp(out,-m_speed,m_speed);
        m_lift.move(out);
    }
    @Override
    public boolean isFinished(){
        if(m_pid.onTarget(4) || m_elapsedTimer.seconds() > m_timeOut){
            m_lift.move(0);
            return true;
        }
        return false;
    }
}
