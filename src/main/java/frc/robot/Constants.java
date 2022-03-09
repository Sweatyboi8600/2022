// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
     /**
      * Different color IDs
      */
    public static abstract class Colors {
       
        
        //public static final Color kBlueTarget = ColorMatch.makeColor(0.136, 0.412, 0.450);
        public static final Color kBlueTarget = new Color(0.136, 0.412, 0.450);
        public static final Color kRedTarget = new  Color (0.475, 0.371, 0.153);
      
    }
    /**
     * Class holding all information pertaining to talons
     */
    public static abstract class Talons {
        /**
         * Class holding talon IDs
         */
        public static abstract class IDs {
            public static final int LF_TALON_ID = 0; // Temp
            public static final int LB_TALON_ID = 1; // Temp
            public static final int RF_TALON_ID = 2; // Temp
            public static final int RB_TALON_ID = 3; // Temp
            public static final int LSHOOT_TALON_ID = 4; // Temp
            public static final int RSHOOT_TALON_ID = 5; // Temp
            public static final int CONVEY_TALON_ID = 6; // Temp
            public static final int ARM_TALON_ID = 7; // Temp
            public static final int LELV_TALON_ID = 8; // Temp
            public static final int RELV_TALON_ID = 9; // Temp

        }

        /**
         * Class holding the talon inversions
         */
        public static abstract class Inversions {
            public static final boolean LF_TALON_INVERT = true; // Temp
            public static final boolean LB_TALON_INVERT = true; // Temp
            public static final boolean RF_TALON_INVERT = false; // Temp
            public static final boolean RB_TALON_INVERT = false; // Temp
            public static final boolean LSHOOT_TALON_INVERT = true; // Temp
            public static final boolean RSHOOT_TALON_INVERT = false; // Temp
            public static final boolean CONVEY_TALON_INVERT = true; // Temp
            public static final boolean ARM_TALON_INVERT = true; // Temp
            public static final boolean LELV_TALON_INVERT = true; // Temp
            public static final boolean RELV_TALON_INVERT = false; // Temp
        }

        /**
         * Class holding the talon speeds
         */
        public static abstract class Speeds {
            public static final double LF_TALON_SPEED = 1.0; // Temp
            public static final double RF_TALON_SPEED = 1.0; // Temp-
            public static final double SHOOT_TALON_SHOOT_SPEED = 1.0; // Temp
            public static final double SHOOT_TALON_INTAKE_SPEED = -1.0; // Temp
            public static final double CONVEY_TALON_SHOOT_SPEED = 1.0; // Temp
            public static final double CONVEY_TALON_INTAKE_SPEED = 1.0; // Temp
            public static final double ARM_TALON_SHOOT_SPEED = 1.0; // Temp
            public static final double ARM_TALON_INTAKE_SPEED = 1.0; // Temp
            public static final double LELV_TALON_SPEED = 1.0; // Temp
            public static final double RELV_TALON_SPEED = 1.0; // Temp

        }
    
        /**
         * Class holding encoder infromation
         */
        public static abstract class Encoders {

            /**
             * Class holding DIO port information
             */
            public static abstract class DIOs {
                public static final int[] ARM_ENCODER_PORT = {0, 1}; // Temp
                public static final int[] ELV_ENCODER_PORT = {2, 3}; // Temp
            }

            /**
             * Class holding distance per pulse
             */
            public static abstract class DPRs {
                public static final double ARM_ENCODERS_DPR = 4./256; // Temp
                public static final double ELV_ENCODERS_DPR = 4./256; // Temp
            }

            /**
             * Class holding distance limits for encoders
             */
            public static abstract class Distances {
                public static final double ARM_INTAKE_DISTANCE = 0;
                public static final double ARM_SHOOT_DISTANCE = 1;
                public static final double ELV_UP_DISTANCE = 1;
                public static final double ELV_DO_DISTANCE = 0;
            }
        }
    }

    /**
     * Class holding all information pertaining to the joysticks and their bindings
     */
    public static abstract class Controls {
        /**
         * Class holding the IDs of the joysticks
         */
        public static abstract class JoystickIDs {
            public static final int DRIVER_ID = 0;
            public static final int OP_ID = 1;
        }

        /**
         * Class holding the IDs of the axis (mostly for driver)
         */
        public static abstract class AxisIDs {
            public static final int FORWARD_AXIS_ID = 0;
            public static final int ROTATION_AXIS_ID = 1;
            public static final int THROTTLE_AXIS_ID = 3;
        }

        /**
         * Class holding the ids of the buttons (mostly for operator)
         */
        public static abstract class ButtonIDs {
            public static final int SHOOT_BUTTON_ID = 0; // Temp;
            public static final int INTAKE_BUTTON_ID = 1; // Temp;
            public static final int ELV_UP_BUTTON_ID = 2; // Temp;
            public static final int ELV_DO_BUTTON_ID = 3; // Temp;
            public static final int ARM_UP_BUTTON_ID = 4; // Temp;
            public static final int ARM_DO_BUTTON_ID = 5; // Temp;
        }
    }
}
