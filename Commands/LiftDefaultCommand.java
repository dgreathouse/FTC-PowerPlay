package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.k;

public class LiftDefaultCommand extends CommandBase {
    private final LiftSubsystem m_liftSubsystem;
    CommandOpMode m_opMode;
    public LiftDefaultCommand(CommandOpMode _opMode, LiftSubsystem _liftSubsystem) {
        m_liftSubsystem = _liftSubsystem;
        m_opMode = _opMode;
    }

    @Override
    public void initialize(){
        Hw.lift.setRunMode(Motor.RunMode.RawPower);
    }
    @Override
    public void execute(){
        double up = Hw.gpOperator.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER);
        double down = Hw.gpOperator.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);

        double speed = up - down;
        m_liftSubsystem.move(speed);
    }
}
