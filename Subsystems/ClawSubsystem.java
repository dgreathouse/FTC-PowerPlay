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
        Hw.leftClaw.turnToAngle(k.CLAW.LeftClose);
        Hw.rightClaw.turnToAngle(k.CLAW.RightClose);
    }
    public void open() {
        Hw.leftClaw.turnToAngle(k.CLAW.LeftOpen);
        Hw.rightClaw.turnToAngle(k.CLAW.RightOpen);
    }
    public void setAngle(double _left, double _right){
        Hw.leftClaw.turnToAngle(_left);
        Hw.rightClaw.turnToAngle(_right);
    }
    @Override
    public void periodic(){

    }

}
