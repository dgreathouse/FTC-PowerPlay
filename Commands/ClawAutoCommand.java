package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.Utility.ClawEnum;
import org.firstinspires.ftc.teamcode.Utility.Hw;


public class ClawAutoCommand extends CommandBase {
    ClawSubsystem m_claw;
    ClawEnum m_dir;
    ElapsedTime m_elapsedTimer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    CommandOpMode m_opMode;
    public ClawAutoCommand(CommandOpMode _opMode, ClawSubsystem _subsystem, ClawEnum _dir){
        addRequirements(_subsystem);
        m_opMode = _opMode;
        m_claw = _subsystem;
        m_dir = _dir;

    }
    @Override
    public void initialize(){
        m_elapsedTimer.reset();
        switch (m_dir){
            case OPEN:
                m_claw.open();
                break;
            case CLOSE:
                m_claw.close();
                break;

        }
        m_elapsedTimer.reset();
        while(m_elapsedTimer.seconds() < 1){}
    }

    @Override
    public boolean isFinished(){
         return true;
    }
}
