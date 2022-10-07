package org.firstinspires.ftc.teamcode.Utility;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


public class Hw {
    public static DcMotorEx leftDrive = null;
    public static DcMotorEx rightDrive = null;
    public static DcMotorEx backDrive = null;
    public static Motor lift = null;
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
        leftDrive  = opMode.hardwareMap.get(DcMotorEx .class, "l");
        rightDrive = opMode.hardwareMap.get(DcMotorEx.class, "r");
        backDrive = opMode.hardwareMap.get(DcMotorEx.class, "b");
        lift = new Motor(opMode.hardwareMap,"lift",384.5,435);
        // lift = opMode.hardwareMap.get(DcMotorEx.class, "lift");

        leftClaw = new SimpleServo(opMode.hardwareMap, "lc", 0, 270);
        rightClaw = new SimpleServo(opMode.hardwareMap, "lc", 0, 270);
        liftEx = new SimpleServo(opMode.hardwareMap, "lex", 0, 270);

        //leftClaw = opMode.hardwareMap.get(Servo .class,"lc");
        //rightClaw = opMode.hardwareMap.get(Servo.class,"rc");
        //liftEx = opMode.hardwareMap.get(Servo.class, "lex");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        backDrive.setDirection(DcMotor.Direction.FORWARD);


        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setRunMode(Motor.RunMode.RawPower);


        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        RevIMU imu = new RevIMU(opMode.hardwareMap);
        imu.init();

        colorSensor = opMode.hardwareMap.get(RevColorSensorV3.class, "cs");

        gpDriver = new GamepadEx(opMode.gamepad1);
        gpOperator = new GamepadEx(opMode.gamepad2);

        opMode.telemetry.addData(">", "Hardware Initialized");


    }
}
