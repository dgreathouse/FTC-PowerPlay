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

                * */
                /* Software routine to initialize robot
                1. Close claw
                2. Drive forward to allow arm up from plexiglass
                3. Raise arm with servo at the same time as winding up some excess line.
                4. Raise Claw so color sensor can see the symbol
                5. Drive forward to Symbol and sense the color
                6. Drive forward to put symbol on other side


                What does this do for lift. Lift needs to have the counts reset before raising so
                a zero at the bottom is created.
                * */
//                new ParallelCommandGroup(
//
//                ),

//                // Close the claw to grab the cone
//                new ClawAutoCommand(_opMode, _claw, ClawEnum.CLOSE),
//                // Drive Forward away from wall
//                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.5, 10, 5.0),
//                // The lift servo should exit immediately but the command should continue to the servo
//                new LiftAutoExtendCommand(_opMode,_lift, 142),
//                // Slowly wind the excess up. This will exit when done.
//                new LiftAutoMoveCommand(_opMode,_lift,2,0.2,4),
//                // Raise the lift to get claw our of the way of the symbol
//                new LiftAutoMoveCommand(_opMode,_lift,6,0.5,4)


                new LiftAutoExtendCommand(_opMode,_lift, -300)




               // new ColorSensorSenseCommand(_opMode, _color),
               // new LiftAutoMoveCommand(_opMode, _lift, k.LIFT.ConeHeightLow)
               // Drive Forward away from wall
//                new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, 10, 5.0),
//                new DriveAutoRotateCommand(_opMode, _drive, 90, 0.5, 5.0)
//                // Raise arm to extended position
//                new LiftAutoExtendCommand(_opMode,_lift, k.LIFT.AutoExtendAngle),
//
//            // Raise Lift to the Low bar to be above the signal cone
//            new LiftAutoMoveCommand(_opMode, _lift, k.LIFT.ConeHeightLow),
//            // Drive to the signal cone
//            new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, 24, 3.0),
//            // Sense the signal and set the variable k.COLOR.ColorNumber to the correct value
//            new ColorSensorSenseCommand(_opMode, _color),
//            // Drive forward to push signal cone to mid field
//            new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, 24, 3.0),
//            // Raise to the Hi junction
//            new LiftAutoMoveCommand(_opMode, _lift, k.LIFT.ConeHeightHi),
//            // Drive backwards to leave the cone on the other teams side
//            new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, -10, 3.0),
//            // Rotate to the Hi junction
//            new DriveAutoRotateCommand(_opMode, _drive, 90, 0.5, 2.0),
//            // Drive forward to Hi junction
//            new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, 24, 3.0),
//            // Release the Claw to drop the cone
//            new ClawAutoCommand(_opMode, _claw, k.CLAW.Open),
//            // Drive backwards to leave the junction and line up with the 5 cones
//            new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, -10, 3.0),
//            // Rotate to the set of 5 cones
//            new DriveAutoRotateCommand(_opMode, _drive, 90, 0.5, 2.0),
//            new LiftAutoMoveCommand(_opMode, _lift, k.LIFT.ConeHeight5),
//            // Drive to 5 cones and lower lift to top cone height
//            new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, -10, 3.0),
//            // Close the Claw to grab the cone
//            new ClawAutoCommand(_opMode, _claw, k.CLAW.Close),
//            // Raise the lift to Mid level to get cone off the stack
//            new LiftAutoMoveCommand(_opMode, _lift, k.LIFT.ConeHeightMid),
//            // lower cone to floor
//            new LiftAutoMoveCommand(_opMode, _lift, k.LIFT.LimitDown_In),
//            // Drive backwards to signal location to park
//            new DriveAutoMoveCommand(_opMode,_drive, DAngle.ang_0, 0.75, -6+((k.COLOR.ColorNumber-1)*24), 3.0)
//

        );
    }
}
