# FTC-PowerPlay
FTC Robot Code for 2022-23 PowerPlay game that utilizes FTCLib

These are only the files and folders for the teamcode folder.
To utilize this code you must have FTCLib setup with android studio.
Simply copy the folders and files to the teamcode folder and compile.

The Robot for this code is as follows.
Chassis:
   Three (3) wheel omni holonomic drive system with wheels 120 degrees apart.
   96mm diameter Gobilda wheels
   
Lift:
   Single Gobilda pulley system to raise a one stage lift 35 inches
   Lift has a servo that extends an arm up at the beginning of the match to create the 35 inch extension.

Claw:
   The claw or cone grabber is a set of two servo with 3d printed fingers on each servo to grab the cone.
   The claw assembly rides on a linear slide up the 35 inch lift. The Claw is gravity fed down and pulled up with a motor.
   
Color Sensor:
   A Rev Color Sensor is used to detect the Location after the robot moves forward to the distance needed for the sensor.
   
Autonomous:
Park in team supplied sleeve location
Place cone on High junction
Grab and place cone on High junction
Grab cone and park at sensed location
Depending on time, do more cones.

Conventions for motor hookup
Power Red to Red, Black to Black, Rotate Right Encoder is positive for all Encoders

