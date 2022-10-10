package org.firstinspires.ftc.teamcode.Utility;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public final class k {
    public static final class DRIVE {
        public static final double InchPerCount = 0.03095;
        public static final double AngleLimit = 0.8;
        public static final PIDFCoefficients MovePIDFCoef= new PIDFCoefficients(0.05,0.00425,0.35,0);
        public static final PIDFCoefficients MoveRotatePIDFCoef= new PIDFCoefficients(1,0,0,0);
        public static final PIDFCoefficients RotatePIDFCoef= new PIDFCoefficients(0.01,0,0,0);
        public static final double RotationScale = 0.5;
    }

    public static final class LIFT {
        public static final double LimitUp_In = 32.5;
        public static final double LimitDown_In = 0;
        public static final double AutoExtendAngle = 200;
        public static final double AutoPID_P = 0.3;
        public static final int ConeHeightLow = 200;
        public static final int ConeHeightMid = 300;
        public static final int ConeHeightHi = 400;
        public static final int ConeHeightJunction = 100;
        public static final int ConeHeight5 = 20;
        public static final double InchPerCnt = 0.008201937;
        public static double AutoLocationInches = 0.0;
        public static double AutoMaxSpeed = 1.0;
    }

    public static final class CLAW {
        public static final double LeftOpen = 115;  // Leave
        public static final double LeftClose = LeftOpen - 60;
        public static final double RightOpen = 0;  // Leave
        public static final double RightClose = RightOpen + 60;
    }

    public static final class COLOR {
        public static final int ColorRedLimit = 1000;
        public static final int ColorGreenLimit = 1000;
        public static final int ColorBlueLimit = 1000;
        public static int ColorNumber = 1;

    }


}
