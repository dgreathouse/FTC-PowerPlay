package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.k;

public class ArmDefaultCommand extends CommandBase {
    private ArmSubsystem m_armSubsystem;
    CommandOpMode m_opMode;
    public ArmDefaultCommand(CommandOpMode _opMode, ArmSubsystem _liftSubsystem) {
        m_armSubsystem = _liftSubsystem;
        m_opMode = _opMode;
        addRequirements(m_armSubsystem);
    }

    @Override
    public void initialize(){


    }
    @Override
    public void execute(){
        Hw.liftEx.setPosition(k.LIFT.AutoExtendAngle);


    }
}
