package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.k;

public class LiftSubsystem extends SubsystemBase {
    CommandOpMode m_opMode;
    public LiftSubsystem(CommandOpMode _opMode){
        m_opMode = _opMode;
    }

    /** TeleOp move based on speed
     *  Limits checked and speed = 0 if beyond directional limits
     * @param _speed +/- 1.0 speed to give the motor
     */
    public void move(double _speed){
        // set a variable called counts to the current lift position
        double cnts = Hw.lift.getCurrentPosition();
        // Stop the lift if it is being commanded a speed in the direction where it is exceeding
        // the mechanical limits of counts for up and down.
        if(_speed > 0 && cnts > k.LIFT.LimitUp_Cnts) {
            _speed = 0;
        }else if ( _speed < 0 && cnts < k.LIFT.LimitDown_Cnts){
            _speed = 0;
        }
        Hw.lift.set(_speed);
    }

    /** Autonomous move to goto a position of counts
     *  Motor is set to RUN_USING_ENCODER
     * @param _cnts
     */
    public void moveAuto(int _cnts){
        Hw.lift.setRunMode(Motor.RunMode.PositionControl);
        Hw.lift.setPositionCoefficient(k.LIFT.AutoPID_P);
        Hw.lift.setTargetPosition(_cnts);
    }
    public void armMove(double _angle) {
        Hw.liftEx.turnToAngle(_angle);
    }
    @Override
    public void periodic() {
        m_opMode.telemetry.addData("Lift Cnts = ", Hw.lift.getCurrentPosition());
    }
}
