package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;

public class LiftAutoExtendCommand extends CommandBase {
    LiftSubsystem m_lift;
    CommandOpMode m_opMode;
    double m_angle;
    public LiftAutoExtendCommand(CommandOpMode _opMode, LiftSubsystem _lift, double _angle){
        addRequirements(_lift);
        m_lift = _lift;
        m_opMode = _opMode;
        m_angle = _angle;
    }
    @Override
    public void initialize(){
        m_lift.armMove(m_angle);
    }
    @Override
    public void execute(){

    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
