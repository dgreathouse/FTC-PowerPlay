package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem;


public class ClawAutoCommand extends CommandBase {
    ClawSubsystem m_claw;
    double m_leftAngle, m_rightAngle;
    CommandOpMode m_opMode;
    public ClawAutoCommand(CommandOpMode _opMode, ClawSubsystem _subsystem, double _leftAngle, double _rightAngle){
        addRequirements(_subsystem);
        m_opMode = _opMode;
        m_claw = _subsystem;
        m_leftAngle = _leftAngle;
        m_rightAngle = _rightAngle;
    }
    @Override
    public void initialize(){
        m_claw.setAngle(m_leftAngle, m_rightAngle);
    }

    @Override
    public boolean isFinished(){
         return true;
    }
}
