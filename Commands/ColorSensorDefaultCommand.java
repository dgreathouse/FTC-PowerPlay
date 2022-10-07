package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.ColorSensorSubsystem;

public class ColorSensorDefaultCommand extends CommandBase {

    ColorSensorSubsystem m_color;
    CommandOpMode m_opMode;

    public ColorSensorDefaultCommand(CommandOpMode _opMode, ColorSensorSubsystem _color){
        m_color = _color;
        m_opMode = _opMode;
    }
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }
}
