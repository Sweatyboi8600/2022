// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  TalonSRX left, right;
  

  /** Creates a new Arm. */
  public Arm() {
    left = new TalonSRX(Constants.Talons.IDs.LARM_TALON_ID);
    left.setInverted(Constants.Talons.Inversions.LARM_TALON_INVERT);

    right = new TalonSRX(Constants.Talons.IDs.RARM_TALON_ID);
    right.setInverted(Constants.Talons.Inversions.RARM_TALON_INVERT);

    left.setNeutralMode(NeutralMode.Brake);
    right.setNeutralMode(NeutralMode.Brake);
  }

  public void set(double speed) {
    left.set(ControlMode.PercentOutput, speed);
    right.set(ControlMode.PercentOutput, speed);
  }

  public double getDistance() {
    return left.getSelectedSensorPosition();
  }

  public boolean isInThreshold(double target) {
    return Math.abs(target - getDistance()) < Constants.Sensors.Encoders.Distances.THRESHOLD;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Arm Encoder", getDistance());
  }
}
