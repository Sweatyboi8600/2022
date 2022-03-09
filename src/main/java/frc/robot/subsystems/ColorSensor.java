// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants;

public class ColorSensor extends SubsystemBase {

  private final ColorSensorV3 m_colorSensor;
  private final ColorMatch m_colorMatch;

  /** Creates a new Color_Sensor. */
  public ColorSensor() {
    m_colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    m_colorMatch = new ColorMatch();

    m_colorMatch.addColorMatch(Constants.Colors.kBlueTarget);
    m_colorMatch.addColorMatch(Constants.Colors.kRedTarget);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Color c = m_colorMatch.matchClosestColor(m_colorSensor.getColor()).color;

    SmartDashboard.putBoolean("color", c == Constants.Colors.kBlueTarget);
  }
}