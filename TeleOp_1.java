package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.ClawDefaultcommand;
import org.firstinspires.ftc.teamcode.Commands.DriveDefaultCommand;
import org.firstinspires.ftc.teamcode.Commands.LiftDefaultCommand;
import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.Hw;

@TeleOp(name = "TeleOp 1", group = "Linear OpMode")
public class TeleOp_1 extends CommandOpMode {

    DriveSubsystem drive;
    LiftSubsystem lift;
    ClawSubsystem claw;
    @Override
    public void initialize() {
        // Initialize hardware
        Hw hw = new Hw(this);
        hw.init();

        // Create Subsystems
        drive = new DriveSubsystem(this);
        lift = new LiftSubsystem(this);
        claw = new ClawSubsystem(this);

        // Create Commands
        DriveDefaultCommand driveDefaultCommand = new DriveDefaultCommand(this, drive);
        LiftDefaultCommand liftDefaultCommand = new LiftDefaultCommand(this, lift);
        ClawDefaultcommand clawDefaultcommand = new ClawDefaultcommand(this, claw);

        // Create buttons
//        Button clawCloseButton = new GamepadButton(Hw.gpDriver, GamepadKeys.Button.RIGHT_BUMPER);
//        clawCloseButton.whenPressed(new InstantCommand(() -> {
//            claw.close();
//        }));
//        Button clawOpenButton = new GamepadButton(Hw.gpDriver, GamepadKeys.Button.LEFT_BUMPER);
//        clawOpenButton.whenPressed(new InstantCommand(() -> {
//            claw.open();
//        }));
        Hw.gpOperator.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .and(Hw.gpOperator.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).negate())
                        .whenActive(new InstantCommand(() ->claw.open(), claw));
        Hw.gpOperator.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .and(Hw.gpOperator.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).negate())
                .whenActive(new InstantCommand(() -> claw.close(), claw));
        // register Subsystems
        register(drive, lift, claw);

        // Set Default Commands
        drive.setDefaultCommand(driveDefaultCommand);
        lift.setDefaultCommand(liftDefaultCommand);
        claw.setDefaultCommand(clawDefaultcommand);
    }

    @Override
    public void runOpMode() throws InterruptedException{
        initialize();

        waitForStart();

        // run the scheduler
        while (!isStopRequested() && opModeIsActive()) {
            run();
            telemetry.update();
        }
        reset();
    }
}
