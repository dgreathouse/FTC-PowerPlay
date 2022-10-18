package org.firstinspires.ftc.teamcode.Commands;


import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

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
    public AutoTest(CommandOpMode _opMode, DriveSubsystem _drive, LiftSubsystem _lift, ClawSubsystem _claw, ColorSensorSubsystem _color) {

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

                // Close the claw to grab the cone
                new ClawAutoCommand(_opMode, _claw, ClawEnum.CLOSE),
                // Drive Forward away from wall
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, 10, 5.0),
                // The lift servo should exit immediately but the command should continue to the servo
                new LiftAutoExtendCommand(_opMode,_lift, 142),
                // Raise Lift to take up the slack
                new LiftAutoMoveCommand(_opMode, _lift, 2, 0.2, 3),
                // Reset the encoder so 0 is all the way down
                new LiftAutoResetEncoder(_opMode,_lift),
                // Raise the lift to get claw our of the way of the symbol
                new LiftAutoMoveCommand(_opMode,_lift,10,0.5,4),
                // Drive forward to signal cone
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, 8, 5.0),
                // Sense the color
                new ColorSensorSenseCommand(_opMode, _color),
                // Drive to centerline
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, 30, 5.0),
                // Backup
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, -4, 5.0),
                // Raise to High
                new LiftAutoMoveCommand(_opMode,_lift,k.LIFT.ConeHeightHi,0.5,4),
                // Rotate to the High
                new DriveAutoRotateCommand(_opMode, _drive, 35, 0.5, 5.0),
                // Drive to junction
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, 7, 5.0),
                // Open the claw
                new ClawAutoCommand(_opMode, _claw, ClawEnum.OPEN),
                // Drive back from junction
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, 7, 5.0),
                // Rotate to the Cones
                new DriveAutoRotateCommand(_opMode, _drive, -90, 0.5, 5.0),
                // Lower to the stack # 5 cone height
                new LiftAutoMoveCommand(_opMode,_lift,k.LIFT.ConeHeight5,0.5,4),
                // Drive to cone stack
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, 20, 5.0),
                // Close the claw to grab the cone
                new ClawAutoCommand(_opMode, _claw, ClawEnum.CLOSE),
                // Raise to Mid level
                new LiftAutoMoveCommand(_opMode,_lift,k.LIFT.ConeHeightMid,0.5,4),
                // Drive backwards to signal location to park
                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, -6+((k.COLOR.ColorNumber-1)*24), 3.0)


//

        );
    }
}
