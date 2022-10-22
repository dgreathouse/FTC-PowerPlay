package org.firstinspires.ftc.teamcode.Commands;


import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ColorSensorSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.Utility.ClawEnum;
import org.firstinspires.ftc.teamcode.Utility.DAngle;
import org.firstinspires.ftc.teamcode.Utility.k;

public class AutoTest extends SequentialCommandGroup {

/* Line up on the Right side facing the cone with the arm down and touching the wall


 */
    public AutoTest(CommandOpMode _opMode, DriveSubsystem _drive, LiftSubsystem _lift, ClawSubsystem _claw, ColorSensorSubsystem _color, ArmSubsystem _arm) {

        addCommands(
                /* Setup Routine for robot before match.
                1. Lower arm all the way back to floor.
                2. Open Claw
                3. Put Claw down to height of cone
                4. Remove any slack in the line
                5. Ensure the line is in the pulleys
                6. Place on field with battery off and phone disconnected
                7. Place on field facing the symbol with arm touching side of plexiglass
                8. Plug in phone and turn on battery
                */
//                new ParallelCommandGroup(
//
//                ),
                new ParallelCommandGroup(
                    // Close the claw to grab the cone
                    new ClawAutoCommand(_opMode, _claw, ClawEnum.CLOSE),
                    // Drive Forward away from wall
                    new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, 8, 5.0)
                ),
                new ParallelCommandGroup(
                    // The lift servo should exit immediately but the command should continue to the servo
                    new ArmAutoExtendCommand(_opMode,_arm, k.LIFT.AutoExtendAngle),
                    // Raise Lift to take up the slack
                    new LiftAutoMoveCommand(_opMode, _lift, 3.75, 0.19, 2)
                ),
                // Reset the encoder so 0 is all the way down
                new LiftAutoResetEncoder(_opMode,_lift),

                new ParallelCommandGroup(
                    // Raise lift to Hi Junction
                    new LiftAutoMoveCommand(_opMode, _lift, 32, 0.75, 3),
                    // Sense the color after a delay while pushing cone
                    new ColorSensorSenseCommand(_opMode, _color,3),
                    // Drive forward to center line
                    new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, 48, 5.0)
                ),
//
                // Drive to Hi Junction at an angle
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_60, 0.5, 10, 5.0),
                // Open the Claw to drop on Hi Junction
                new ClawAutoCommand(_opMode, _claw, ClawEnum.OPEN),

                new ParallelCommandGroup(
                    // Drive back to line up with stack of 5 cones
                    new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_60, 0.5, 10, 5.0),
                    // Lower lift to Cone 5 height
                    new LiftAutoMoveCommand(_opMode, _lift, k.LIFT.ConeHeightHi, 0.75, 3)
                ),
                // Rotate to the stack of 5 cones
                new DriveAutoRotateCommand(_opMode, _drive, -90, 0.5, 5.0),
                // Drive to stack of 5 cones
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, 7, 5.0),
                // Close the claw to grab the cone
                new ClawAutoCommand(_opMode, _claw, ClawEnum.CLOSE),
                // Raise to High
                new LiftAutoMoveCommand(_opMode,_lift,k.LIFT.ConeHeightMid,0.5,4),

                new ParallelCommandGroup(
                    // Drive backwards to signal location to park
                    new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, -6-((k.COLOR.ColorNumber-1)*22), 3.0), // -6 -28 -50
                    // Lower Lift so the transition from Auto to Teleop does not let go of cone
                    new LiftAutoMoveCommand(_opMode,_lift,k.LIFT.ConeHeightJunction,0.5,4)
                )
        );
    }
}
