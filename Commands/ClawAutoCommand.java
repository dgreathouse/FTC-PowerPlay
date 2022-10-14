package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem;


public class ClawAutoCommand extends CommandBase {
    ClawSubsystem m_claw;
    double m_angle;
    CommandOpMode m_opMode;
    public ClawAutoCommand(CommandOpMode _opMode, ClawSubsystem _subsystem, double _angle){
        addRequirements(_subsystem);
        m_opMode = _opMode;
        m_claw = _subsystem;
        m_angle = _angle;

    }
    @Override
    public void initialize(){
        m_claw.setAngle(m_angle);
    }

    @Override
    public boolean isFinished(){
         return true;
    }
}
