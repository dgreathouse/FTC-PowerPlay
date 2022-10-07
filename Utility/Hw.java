package org.firstinspires.ftc.teamcode.Utility;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Hw {
    public static MotorEx leftDrive = null;
    public static MotorEx rightDrive = null;
    public static MotorEx backDrive = null;
    public static MotorEx lift = null;
    public static SimpleServo leftClaw = null;
    public static SimpleServo rightClaw = null;
    public static SimpleServo liftEx = null;
    public static RevIMU imu;
    public static GamepadEx gpDriver, gpOperator;
    public static RevColorSensorV3 colorSensor;
    private LinearOpMode opMode = null;

    public Hw(LinearOpMode _opMode) {
        opMode = _opMode;
    }
    public void init(){

        leftDrive = new MotorEx(opMode.hardwareMap, "l", Motor.GoBILDA.RPM_435);
        leftDrive.setInverted(true);
        leftDrive.setRunMode(Motor.RunMode.RawPower);
        leftDrive.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        leftDrive.setDistancePerPulse(k.DRIVE.InchPerCount);

        rightDrive = new MotorEx(opMode.hardwareMap, "r", Motor.GoBILDA.RPM_435);
        rightDrive.setInverted(false);
        rightDrive.setRunMode(Motor.RunMode.RawPower);
        rightDrive.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightDrive.setDistancePerPulse(k.DRIVE.InchPerCount);

        backDrive = new MotorEx(opMode.hardwareMap, "b", Motor.GoBILDA.RPM_435);
        backDrive.setInverted(false);
        backDrive.setRunMode(Motor.RunMode.RawPower);
        backDrive.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backDrive.setDistancePerPulse(k.DRIVE.InchPerCount);

        lift = new MotorEx(opMode.hardwareMap,"lift", Motor.GoBILDA.RPM_312);
        lift.setInverted(false);
        lift.setRunMode(Motor.RunMode.RawPower);
        lift.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        lift.setDistancePerPulse(k.LIFT.InchPerCnt);

        leftClaw = new SimpleServo(opMode.hardwareMap, "lc", 0, 270);
        rightClaw = new SimpleServo(opMode.hardwareMap, "rc", 0, 270);
        liftEx = new SimpleServo(opMode.hardwareMap, "lex", 0, 270);

        RevIMU imu = new RevIMU(opMode.hardwareMap);
        imu.init();

        colorSensor = opMode.hardwareMap.get(RevColorSensorV3.class, "cs");

        gpDriver = new GamepadEx(opMode.gamepad1);
        gpOperator = new GamepadEx(opMode.gamepad2);

        opMode.telemetry.addData(">", "Hardware Initialized");

    }
}
