// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Shooter;

public class AutoShoot extends CommandBase {

  private final Shooter m_shooter;
  private final ColorSensor m_colorSensor;

  /** Creates a new Intake. */
  public AutoShoot(Shooter shooter, ColorSensor colorSensor) {
    m_shooter = shooter;
    m_colorSensor = colorSensor;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooter, m_colorSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.setFlyWheels(Constants.Talons.Speeds.AUTO_SHOOT_SPEED);
    m_shooter.setConvey(Constants.Talons.Speeds.CONVEY_TALON_SHOOT_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.setFlyWheels(0);
    m_shooter.setConvey(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //return false;
    return !m_colorSensor.isAllianceColor();
  }
}
