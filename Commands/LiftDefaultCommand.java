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
        addRequirements(m_liftSubsystem);
    }

    @Override
    public void initialize(){

        Hw.lift.setRunMode(Motor.RunMode.RawPower);
       // Hw.liftEx.setPosition(0.0);
    }
    @Override
    public void execute(){
//        double up = Hw.gpOperator.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER);
//        double down = Hw.gpOperator.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);
//
//        double speed = up - down;
        double speed = Hw.gpOperator.getRightX();
        m_liftSubsystem.move(speed);

//        double arm = Hw.gpDriver.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);
//        if(arm > 0.5){
//            m_liftSubsystem.armMove(0.25);
//        }else {
//            m_liftSubsystem.armMove(0.0);
//        }

    }
}
