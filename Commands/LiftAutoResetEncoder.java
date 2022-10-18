package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;

public class LiftAutoResetEncoder extends CommandBase {
    LiftSubsystem m_lift;
    CommandOpMode m_opMode;
    public LiftAutoResetEncoder(CommandOpMode _opMode, LiftSubsystem _lift){
        addRequirements(_lift);
        m_lift = _lift;
        m_opMode = _opMode;
    }
    @Override
    public void initialize(){

        m_lift.resetEncoder();
    }
    @Override
    public void execute(){

    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
