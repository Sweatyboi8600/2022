// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  TalonSRX left, right;
  Encoder encoder;

  /** Creates a new Elevator. */
  public Elevator() {
    left = new TalonSRX(Constants.Talons.IDs.LELV_TALON_ID);
    right = new TalonSRX(Constants.Talons.IDs.RELV_TALON_ID);

    left.setInverted(Constants.Talons.Inversions.LELV_TALON_INVERT);
    right.setInverted(Constants.Talons.Inversions.RELV_TALON_INVERT);

    encoder = new Encoder(Constants.Talons.Encoders.DIOs.ELV_ENCODER_PORT[0],
                          Constants.Talons.Encoders.DIOs.ELV_ENCODER_PORT[1]);
    encoder.setDistancePerPulse(Constants.Talons.Encoders.DPRs.ELV_ENCODERS_DPR);
  }

  public void set(double speed) {
    left.set(ControlMode.PercentOutput, speed * Constants.Talons.Speeds.LELV_TALON_SPEED);
    right.set(ControlMode.PercentOutput, speed * Constants.Talons.Speeds.RELV_TALON_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getDistance() {
    return encoder.getDistance();
  }
}
