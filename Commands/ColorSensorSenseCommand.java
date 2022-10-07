package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.ColorSensorSubsystem;

public class ColorSensorSenseCommand extends CommandBase {
    private final ColorSensorSubsystem m_color;
    CommandOpMode m_opMode;
    public ColorSensorSenseCommand(CommandOpMode _opMode, ColorSensorSubsystem _color){
        m_opMode = _opMode;
        m_color = _color;
    }
    @Override
    public void initialize() {
        m_color.senseColor();
    }

    @Override
    public void execute() {

    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
