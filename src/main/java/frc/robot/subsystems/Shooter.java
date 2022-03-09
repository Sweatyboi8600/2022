// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  TalonSRX conveyTalon, leftShootTalon, rightShootTalon;

  /** Creates a new Shooter. */
  public Shooter() {
    conveyTalon = new TalonSRX(Constants.Talons.IDs.CONVEY_TALON_ID);
    leftShootTalon = new TalonSRX(Constants.Talons.IDs.LSHOOT_TALON_ID);
    rightShootTalon = new TalonSRX(Constants.Talons.IDs.RSHOOT_TALON_ID);

    conveyTalon.setInverted(Constants.Talons.Inversions.CONVEY_TALON_INVERT);
    leftShootTalon.setInverted(Constants.Talons.Inversions.LSHOOT_TALON_INVERT);
    rightShootTalon.setInverted(Constants.Talons.Inversions.RSHOOT_TALON_INVERT);

    rightShootTalon.follow(leftShootTalon);
  }

  public void setFlyWheels(double speed) {
    leftShootTalon.set(ControlMode.PercentOutput, speed);
  }

  public void setConvey(double speed) {
    conveyTalon.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
