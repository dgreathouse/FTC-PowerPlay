package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.k;

public class LiftAutoMoveCommand extends CommandBase {
    LiftSubsystem m_lift;
    CommandOpMode m_opMode;
    double m_inches;

    public LiftAutoMoveCommand(CommandOpMode _opMode, LiftSubsystem _lift, double _inches){
        addRequirements(_lift);
        m_lift = _lift;
        m_opMode = _opMode;
        m_inches = _inches;

    }
    @Override
    public void initialize(){
        Hw.lift.setTargetDistance(m_inches);
    }
    @Override
    public void execute(){

    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
