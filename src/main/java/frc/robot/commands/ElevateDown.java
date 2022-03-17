// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class ElevateDown extends CommandBase {
  Elevator m_elevator;

  /** Creates a new ElevateUp. */
  public ElevateDown(Elevator elevator) {
    m_elevator = elevator;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_elevator.set(-Constants.Talons.Speeds.ELV_TALON_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false && m_elevator.getDistance() <= Constants.Sensors.Encoders.Distances.ELV_DO_DISTANCE;
    
  }
}
