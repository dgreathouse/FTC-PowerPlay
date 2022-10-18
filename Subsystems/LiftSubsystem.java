package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.k;

public class LiftSubsystem extends SubsystemBase {
    CommandOpMode m_opMode;
    double m_angle;
    boolean m_limitReached = false;
    double m_speed;
    public LiftSubsystem(CommandOpMode _opMode){

        m_opMode = _opMode;

    }

    /** TeleOp move based on speed
     *  Limits checked and speed = 0 if beyond directional limits
     * @param _speed +/- 1.0 speed to give the motor
     */
    public void move(double _speed){
        m_speed = _speed;
        double rtn = _speed;

        // set a variable called counts to the current lift position
        double in = Hw.lift.getDistance();
        m_limitReached = Hw.liftDIO.getState();
        // Stop the lift if it is being commanded a speed in the direction where it is exceeding
        // the mechanical limits of counts for up and down.
        if(_speed > 0 && in > k.LIFT.LimitUp_In) {
            m_speed = 0;
        }else if ( _speed < 0 && in < k.LIFT.LimitDown_In){
            m_speed = 0;
        }else if (_speed > 0 && m_limitReached){
            m_speed = 0;
        }else {
            m_speed = _speed;
        }
        if(_speed > 0 && in > 25){
            m_speed = m_speed / 2;
        }else if(_speed < 0 && in < 8){
            m_speed = m_speed /2;
        }
        Hw.lift.set(m_speed);
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
    public void resetEncoder(){
        Hw.lift.encoder.reset();
    }
    @Override
    public void periodic() {

        m_opMode.telemetry.addData("Lift In = ", Hw.lift.getDistance());
        m_opMode.telemetry.addData("Lift = ",m_speed);
        m_opMode.telemetry.addData("Lift DIO = ", Hw.liftDIO.getState());
        m_opMode.telemetry.addData("usPulseLower = ", Hw.liftEx.getPwmRange().usPulseLower);
        m_opMode.telemetry.addData("usPulseUpper = ", Hw.liftEx.getPwmRange().usPulseUpper);
        m_opMode.telemetry.addData("LeftEx Pos = ", Hw.liftEx.getPosition());
    }

}
