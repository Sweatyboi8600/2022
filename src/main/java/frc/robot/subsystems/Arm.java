// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  TalonSRX motor;
  Encoder encoder;

  /** Creates a new Arm. */
  public Arm() {
    motor = new TalonSRX(Constants.Talons.IDs.ARM_TALON_ID);
    motor.setInverted(Constants.Talons.Inversions.ARM_TALON_INVERT);

    encoder = new Encoder(Constants.Talons.Encoders.DIOs.ARM_ENCODER_PORT[0],
        Constants.Talons.Encoders.DIOs.ARM_ENCODER_PORT[1]);
    encoder.setDistancePerPulse(Constants.Talons.Encoders.DPRs.ARM_ENCODERS_DPR);
  }

  public void set(double speed) {
    motor.set(ControlMode.PercentOutput, speed);
  }

  public double getDistance() {
    return encoder.getDistance();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
