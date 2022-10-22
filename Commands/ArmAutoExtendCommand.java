package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;

public class ArmAutoExtendCommand extends CommandBase {
    ArmSubsystem m_arm;
    CommandOpMode m_opMode;
    double m_angle;
    public ArmAutoExtendCommand(CommandOpMode _opMode, ArmSubsystem _arm, double _angle){
        addRequirements(_arm);
        m_arm = _arm;
        m_opMode = _opMode;
        m_angle = _angle;
    }
    @Override
    public void initialize(){

        m_arm.move(m_angle);
    }
    @Override
    public void execute(){

    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
