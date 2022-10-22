package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Utility.Hw;

public class ArmSubsystem extends SubsystemBase {
    CommandOpMode m_opMode;
    double m_angle;
    public ArmSubsystem(CommandOpMode _opMode){
        m_opMode = _opMode;
    }
    public void move(double _angle){
        m_angle = _angle;
        Hw.liftEx.setPosition(m_angle);
    }
    @Override
    public void periodic(){
        m_opMode.telemetry.addData("LeftEx Pos = ", Hw.liftEx.getPosition());
    }
}
