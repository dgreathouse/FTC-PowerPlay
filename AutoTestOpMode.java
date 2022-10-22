package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Commands.AutoRightStraightHi;
import org.firstinspires.ftc.teamcode.Commands.AutoTest;
import org.firstinspires.ftc.teamcode.Commands.LiftAutoDefaultCommand;
import org.firstinspires.ftc.teamcode.Subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ColorSensorSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.Hw;

@Autonomous(name = "AutoTest", group = "Test OpModes")
public class AutoTestOpMode extends CommandOpMode {
    DriveSubsystem m_drive;
    LiftSubsystem m_lift;
    ClawSubsystem m_claw;
    ColorSensorSubsystem m_color;
    ArmSubsystem m_arm;
    AutoTest m_auto;
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
        m_arm = new ArmSubsystem(this);
        // Create Commands


        m_auto = new AutoTest(this,m_drive, m_lift, m_claw, m_color, m_arm);

        // register Subsystems
        register(m_drive, m_claw, m_lift, m_color, m_arm);

        // Set Default Commands
    //    m_lift.setDefaultCommand(liftAutoDefaultCommand);
        // Schedule the auto play to run

    }
    @Override
    public void runOpMode() throws InterruptedException{
        initialize();

        waitForStart();
        CommandScheduler.getInstance().schedule(m_auto);
        // run the scheduler
        while (!isStopRequested() && opModeIsActive()) {
            run();
            telemetry.update();
        }
        reset();
    }
}
