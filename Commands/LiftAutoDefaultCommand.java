package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.k;

public class LiftAutoDefaultCommand extends CommandBase {
    private final LiftSubsystem m_liftSubsystem;
    CommandOpMode m_opMode;
    double m_inches;
    public LiftAutoDefaultCommand(CommandOpMode _opMode, LiftSubsystem _liftSubsystem){
        m_liftSubsystem = _liftSubsystem;
        addRequirements(m_liftSubsystem);
        m_opMode = _opMode;
    }
    @Override
    public void initialize(){
        Hw.lift.setRunMode(Motor.RunMode.PositionControl);
        Hw.lift.setPositionCoefficient(k.LIFT.AutoPID_P);
        Hw.lift.setTargetDistance(k.LIFT.AutoLocationInches);
        Hw.lift.setPositionTolerance(1);
    }
    @Override
    public void execute(){
        m_liftSubsystem.moveAuto(k.LIFT.AutoMaxSpeed);
    }
}
