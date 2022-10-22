package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.ColorSensorSubsystem;

public class ColorSensorSenseCommand extends CommandBase {
    private final ColorSensorSubsystem m_color;
    CommandOpMode m_opMode;
    double m_timeOut;
    ElapsedTime m_elapsedTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    public ColorSensorSenseCommand(CommandOpMode _opMode, ColorSensorSubsystem _color, double _timeDelay){
        m_opMode = _opMode;
        m_color = _color;
        m_timeOut = _timeDelay;
    }
    @Override
    public void initialize() {
        m_elapsedTimer.reset();

    }

    @Override
    public void execute() {

    }
    @Override
    public boolean isFinished(){
        if(m_elapsedTimer.seconds() > m_timeOut){
            m_color.senseColor();
            return true;
        }
        return false;
    }
}
