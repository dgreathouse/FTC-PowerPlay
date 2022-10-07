package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;

public class LiftAutoMoveCommand extends CommandBase {
    LiftSubsystem m_lift;
    CommandOpMode m_opMode;
    int m_cnts;
    public LiftAutoMoveCommand(CommandOpMode _opMode, LiftSubsystem _lift, int _cnts){
        addRequirements(_lift);
        m_lift = _lift;
        m_opMode = _opMode;
        m_cnts = _cnts;
    }
    @Override
    public void initialize(){
        m_lift.moveAuto(m_cnts);
    }
    @Override
    public void execute(){

    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
