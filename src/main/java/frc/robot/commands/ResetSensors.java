// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class ResetSensors extends CommandBase {
  private final Arm m_arm;
  private final Elevator m_elevator;
  /** Creates a new ResetSensors. */
  public ResetSensors(Arm arm, Elevator elevator) {
    m_arm = arm;
    m_elevator = elevator;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_arm, m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_arm.resetEncoder();
    m_elevator.resetEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
