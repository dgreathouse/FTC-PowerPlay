package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.k;

public class LiftSubsystem extends SubsystemBase {
    CommandOpMode m_opMode;
    double m_angle;
    public LiftSubsystem(CommandOpMode _opMode){
        m_opMode = _opMode;
    }

    /** TeleOp move based on speed
     *  Limits checked and speed = 0 if beyond directional limits
     * @param _speed +/- 1.0 speed to give the motor
     */
    public void move(double _speed){
        // set a variable called counts to the current lift position
        double cnts = Hw.lift.getDistance();
        // Stop the lift if it is being commanded a speed in the direction where it is exceeding
        // the mechanical limits of counts for up and down.
        if(_speed > 0 && cnts > k.LIFT.LimitUp_In) {
            _speed = 0;
        }else if ( _speed < 0 && cnts < k.LIFT.LimitDown_In){
            _speed = 0;
        }
        Hw.lift.set(_speed);
    }

    /** Autonomous move to goto a position of counts

     * @param _maxSpeed
     */
    public void moveAuto(double _maxSpeed){
        Hw.lift.set(_maxSpeed);
    }
    public void armMove(double _angle) {
        m_angle = _angle;
        Hw.liftEx.setPosition(m_angle);

    }
    @Override
    public void periodic() {
        m_opMode.telemetry.addData("Lift In = ", Hw.lift.getDistance());
        m_opMode.telemetry.addData("usPulseLower = ", Hw.liftEx.getPwmRange().usPulseLower);
        m_opMode.telemetry.addData("usPulseUpper = ", Hw.liftEx.getPwmRange().usPulseUpper);
        m_opMode.telemetry.addData("LeftEx Pos = ", Hw.liftEx.getPosition());
    }

}
