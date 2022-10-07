package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Utility.Hw;
import org.firstinspires.ftc.teamcode.Utility.DAngle;
import org.firstinspires.ftc.teamcode.Utility.MyMath;
import org.firstinspires.ftc.teamcode.Utility.Vector2d;
import org.firstinspires.ftc.teamcode.Utility.k;

public class DriveSubsystem extends SubsystemBase {
    public static final Vector2d m_leftVec = new Vector2d(Math.cos(30.0 * (Math.PI / 180.0)), Math.sin(30.0 * (Math.PI / 180.0)));
    public static final Vector2d m_rightVec = new Vector2d(Math.cos(150 * (Math.PI / 180.0)), Math.sin(150 * (Math.PI / 180.0)));
    public static final Vector2d m_backVec = new Vector2d(Math.cos(270 * (Math.PI / 180.0)),  Math.sin(270 * (Math.PI / 180.0)));

    CommandOpMode m_opMode;

    public DriveSubsystem(CommandOpMode _opMode){
        m_opMode = _opMode;
    }

    public void driveCartesianIK(double _ySpeed, double _xSpeed, double _zRotation, double _gyroAngle){
        double leftSpeed = 0.0;
        double rightSpeed = 0.0;
        double backSpeed = 0.0;

        MyMath.clamp(_ySpeed, -1.0, 1.0);
        MyMath.clamp(_xSpeed, -1.0, 1.0);
        MyMath.clamp(_zRotation, -1.0, 1.0);

        Vector2d input = new Vector2d(_ySpeed,_xSpeed);
        input.rotate(-_gyroAngle);

        leftSpeed = input.scalarProject(m_leftVec) + _zRotation;
        rightSpeed = input.scalarProject(m_rightVec) + _zRotation;
        backSpeed = input.scalarProject(m_backVec) + _zRotation;

        Hw.leftDrive.setPower(leftSpeed);
        Hw.rightDrive.setPower(rightSpeed);
        Hw.backDrive.setPower(backSpeed);
    }

    /* Each drive motor is a 435 RPM gearbox/motor.
    The Encoder does 384.5 PPR or counts per revolution
    The wheel diameter is 96mm or 3.78in
    The circumference is 301.6mm or 11.875in
    Inch/Count = 11.875/384.5 = 0.030885
     */
    public double getInchesDriven(DAngle _angle){
        double rtn = 0;
        double left = Hw.leftDrive.getCurrentPosition();
        double right = Hw.rightDrive.getCurrentPosition();
        double back = Hw.backDrive.getCurrentPosition();
        switch (_angle){
            case ang_0: // Left, Right
            case ang_180:
                rtn = (left + right)/2 * k.DRIVE.InchPerCount;
                break;
            case ang_60: // Left, Back
            case ang_240:
                rtn = (left + back)/2 * k.DRIVE.InchPerCount;
                break;
            case ang_120: // Right, Back
            case ang_300:
                rtn = (right + right)/2 * k.DRIVE.InchPerCount;
                break;
            default:
                rtn = 0;
                break;
        }
        return rtn;
    }
   public double getAngle(DAngle _angle){
        double rtn = 0.0;
        switch (_angle){
            case ang_0:
                rtn = 0;
                break;
            case ang_60:
                rtn = 60;
                break;
            case ang_120:
                rtn = 120;
                break;
            case ang_180:
                rtn = 180;
                break;
            case ang_240:
                rtn = 240;
                break;
            case ang_300:
                rtn = 300;
                break;
        }
        return rtn;
    }
    public void resetMotors(){
        Hw.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hw.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Hw.backDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Hw.leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Hw.rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Hw.backDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    @Override
    public void periodic() {
//            opMode.telemetry.addData("Left Cnts = ", m_leftMotor.getCurrentPosition());
//            opMode.telemetry.addData("Right Cnts = ", m_rightMotor.getCurrentPosition());
//            opMode.telemetry.addData("Back Cnts = ", m_backMotor.getCurrentPosition());
//            opMode.telemetry.addData("Inches = ", getInchesDriven(_angle));
//            opMode.telemetry.addData("PID Out = ", pidDriveOutput);
//            opMode.telemetry.addData("x = ", x);
//            opMode.telemetry.addData("y = ", y);
//            opMode.telemetry.addData("Time = ", elapsedTimer.seconds());
//            opMode.telemetry.update();
    }
}
