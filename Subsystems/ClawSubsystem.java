package org.firstinspires.ftc.teamcode.Subsystems;


import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.k;

public class ClawSubsystem extends SubsystemBase {
    CommandOpMode m_opMode;

    public ClawSubsystem(CommandOpMode _opMode) {
        m_opMode = _opMode;
    }

    public void close(){
        Hw.clawServo.turnToAngle(k.CLAW.Close);
       // Hw.rightClaw.turnToAngle(k.CLAW.RightClose);
    }
    public void open() {
        Hw.clawServo.turnToAngle(k.CLAW.Open);
      //  Hw.rightClaw.turnToAngle(k.CLAW.RightOpen);
    }
    public void setAngle(double _angle){
        Hw.clawServo.turnToAngle(_angle);
      //  Hw.rightClaw.turnToAngle(_right);
    }
    @Override
    public void periodic(){

    }

}
