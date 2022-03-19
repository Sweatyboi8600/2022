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
     * Class holding information pertaining to vision
     */
    public static abstract class Vision {
        public static final int[] RESOLUTION = {1280, 720};
    }

     /**
      * Different color IDs
      */
    public static abstract class Colors {
       
        public static final boolean IS_BLUE = false;
        public static final double CONF_THRESHOLD = 0.9; // Temp
        public static final Color BLUE_TARGET = new Color(0.136, 0.412, 0.450);
        public static final Color RED_TARGET = new  Color (0.475, 0.371, 0.153);
        
        //public static final Color kBlueTarget = ColorMatch.makeColor(0.136, 0.412, 0.450);
    }
    /**
     * Class holding all information pertaining to talons
     */
    public static abstract class Talons {
        /**
         * Class holding talon IDs
         */
        public static abstract class IDs {
            public static final int LF_TALON_ID = 2; 
            public static final int LB_TALON_ID = 3;
            public static final int RF_TALON_ID = 8; 
            public static final int RB_TALON_ID = 9; 
            public static final int LSHOOT_TALON_ID = 4; 
            public static final int RSHOOT_TALON_ID = 5; 
            public static final int CONVEY_TALON_ID = 10;
            public static final int LARM_TALON_ID = 0;
            public static final int RARM_TALON_ID = 6;
            public static final int LELV_TALON_ID = 1; 
            public static final int RELV_TALON_ID = 7; 

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
            public static final boolean CONVEY_TALON_INVERT = false; // Temp
            public static final boolean LARM_TALON_INVERT = true; // Temp
            public static final boolean RARM_TALON_INVERT = false; // Temp
            public static final boolean LELV_TALON_INVERT = false; // Temp
            public static final boolean RELV_TALON_INVERT = true; // Temp
        }

        /**
         * Class holding the talon speeds
         */
        public static abstract class Speeds {
            public static final double DRIVE_TALON_SPEED = 0.5; // Temp
            
        public static final double AUTO_DRIVE_SPEED = 0.3; // Temp
            public static final double SHOOT_TALON_SHOOT_SPEED = 1.0; // Temp
            public static final double SHOOT_TALON_AUTO_SPEED = 0.5;
            public static final double SHOOT_TALON_INTAKE_SPEED = -0.5; // Temp
            public static final double CONVEY_TALON_SHOOT_SPEED = -0.5; // Temp
            public static final double CONVEY_TALON_INTAKE_SPEED = 0.5; // Temp
            public static final double ARM_TALON_SPEED = 0.2; // Temp
            public static final double ELV_TALON_SPEED = 0.45; // Temp
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
            public static final int FORWARD_AXIS_ID = 1;
            public static final int ROTATION_AXIS_ID = 0;
            public static final int THROTTLE_AXIS_ID = 3;
        }

        /**
         * Class holding the ids of the buttons (mostly for operator)
         */
        public static abstract class ButtonIDs {
            public static final int SHOOT_BUTTON_ID = 1;
            public static final int INTAKE_BUTTON_ID = 2; 
            public static final int ELV_UP_BUTTON_ID = 8;
            public static final int ELV_DO_BUTTON_ID = 10;
            public static final int ARM_INTAKE_BUTTON_ID = 11;
            public static final int ARM_SHOOT_BUTTON_ID = 9;
            public static final int ARM_UP_BUTTON_ID = 7;
            public static final int ARM_MOVE_BUTTON_ID = 12;
        }
    }

    public static abstract class Sensors {
        /**
         * Class holding encoder information
         */
        public static abstract class Encoders {
            public static abstract class Multipliers {
                public static final double ELV_MULT = -1;//-18/13400;
            } 

            /**
             * Class holding distance limits for encoders
             */

             // 0 is top
             // 1 is bottom
            public static abstract class Distances {
                public static final double THRESHOLD = 0.1;
                public static final double ARM_INTAKE_DISTANCE = 0.8;
                public static final double ARM_SHOOT_DISTANCE = 0.24;
                public static final double ARM_UP_DISTANCE = 0.05;
                public static final double ARM_SHOOT_THRESHOLD = 0.05;

                public static final double ELV_DO_DISTANCE = 0.075;
                public static final double ELV_UP_DISTANCE = 1;
            }
        }
        /**
         * Class holding ultrasonic information
         */
        public static abstract class Ultrasonics {
            
            public static final double DISTANCE_MULT = 1; // Temp
            
            public static abstract class DIOs {
                public static final int[] LEFT_PORT = {4, 5}; // Temp
                public static final int[] RIGHT_PORT = {6, 7}; // Temp
            }
            public static abstract class Distances {
                public static final double SLOW_DISTANCE = 500; // Temp
                public static final double MIN_DISTANCE = 300; // Temp
                public static final double BACKWARD_DISTANCE = 1700;
            }
        }

        public static abstract class Gyros {
            public static final double THRESHOLD = 0.5;
            public static abstract class Port {
                public static final int port = 0; // Temp
            }
        }

    }
}
