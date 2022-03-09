// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.ElevateDown;
import frc.robot.commands.ElevateUp;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Intake;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final Drivetrain m_drivetrain = new Drivetrain();

  private final Shooter m_shooter = new Shooter();

  private final Elevator m_elevator = new Elevator();

  private final Joystick m_driverStick = new Joystick(Constants.Controls.JoystickIDs.DRIVER_ID);

  private final Joystick m_operateStick = new Joystick(Constants.Controls.JoystickIDs.OP_ID);

  private JoystickButton intakeButton, shootButton, elevatorUpButton, elevatorDownButton;
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new Drive(m_drivetrain, 
    () -> m_driverStick.getRawAxis(Constants.Controls.AxisIDs.FORWARD_AXIS_ID),
    () -> m_driverStick.getRawAxis(Constants.Controls.AxisIDs.ROTATION_AXIS_ID),
    () -> m_driverStick.getRawAxis(Constants.Controls.AxisIDs.THROTTLE_AXIS_ID)));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    intakeButton = new JoystickButton(m_operateStick, Constants.Controls.ButtonIDs.INTAKE_BUTTON_ID);
    intakeButton.whileHeld(new Intake(m_shooter));
    shootButton = new JoystickButton(m_operateStick, Constants.Controls.ButtonIDs.SHOOT_BUTTON_ID);
    shootButton.whileHeld(new Shoot(m_shooter));
    elevatorUpButton = new JoystickButton(m_operateStick, Constants.Controls.ButtonIDs.ELV_UP_BUTTON_ID);
    elevatorUpButton.toggleWhenActive(new ElevateUp(m_elevator));
    elevatorDownButton = new JoystickButton(m_operateStick, Constants.Controls.ButtonIDs.ELV_DO_BUTTON_ID);
    elevatorDownButton.toggleWhenActive(new ElevateDown(m_elevator));
    

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
