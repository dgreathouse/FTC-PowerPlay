package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem;

public class ClawDefaultcommand extends CommandBase {
    private final ClawSubsystem m_clawSubsystem;
    CommandOpMode m_opMode;
    public ClawDefaultcommand(CommandOpMode _opMode, ClawSubsystem _clawSubsystem) {
        this.m_clawSubsystem = _clawSubsystem;
        m_opMode = _opMode;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }
}