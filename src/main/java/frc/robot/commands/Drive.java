// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {

  private final Drivetrain m_drivetrain;
  private final DoubleSupplier m_forwardSupplier;
  private final DoubleSupplier m_rotationSupplier;
  private final DoubleSupplier m_throttleSupplier;

  /** Creates a new Drive. */
  public Drive(Drivetrain drivetrain,
               DoubleSupplier forwardSupplier, 
               DoubleSupplier rotationSupplier, 
               DoubleSupplier throttleSupplier) {
    m_drivetrain = drivetrain;
    m_forwardSupplier = forwardSupplier;
    m_rotationSupplier = rotationSupplier;
    m_throttleSupplier = throttleSupplier;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = m_forwardSupplier.getAsDouble();
    double rotation = m_rotationSupplier.getAsDouble();
    double throttle = m_throttleSupplier.getAsDouble()/-2 + 0.5;

    m_drivetrain.arcadeDrive(forward, rotation, throttle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
