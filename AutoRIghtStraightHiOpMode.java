package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Commands.AutoRightStraightHi;
import org.firstinspires.ftc.teamcode.Commands.LiftAutoDefaultCommand;
import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ColorSensorSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.Hw;

@Autonomous(name = "Right Straight Hi", group = "Right OpMode")
public class AutoRIghtStraightHiOpMode extends CommandOpMode {
    DriveSubsystem m_drive;
    LiftSubsystem m_lift;
    ClawSubsystem m_claw;
    ColorSensorSubsystem m_color;
    @Override
    public void initialize() {
        // Initialize hardware
        Hw hw = new Hw(this);
        hw.init();

        // Create Subsystems
        m_drive = new DriveSubsystem(this);
        m_lift = new LiftSubsystem(this);
        m_claw = new ClawSubsystem(this);
        m_color = new ColorSensorSubsystem(this);

        // Create Commands
        LiftAutoDefaultCommand liftAutoDefaultCommand = new LiftAutoDefaultCommand(this,m_lift);

        AutoRightStraightHi auto = new AutoRightStraightHi(this,m_drive, m_lift, m_claw, m_color);

        // register Subsystems
        register(m_drive, m_claw, m_lift, m_color);

        // Set Default Commands
        m_lift.setDefaultCommand(liftAutoDefaultCommand);
        // Schedule the auto play to run
        CommandScheduler.getInstance().schedule(auto);
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
