// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

TalonSRX LFTalon, LBTalon, RFTalon, RBTalon;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    LFTalon = new TalonSRX(Constants.Talons.IDs.LF_TALON_ID);
    LBTalon = new TalonSRX(Constants.Talons.IDs.LB_TALON_ID);
    RFTalon = new TalonSRX(Constants.Talons.IDs.RF_TALON_ID);
    RBTalon = new TalonSRX(Constants.Talons.IDs.RB_TALON_ID);

    LFTalon.setInverted(Constants.Talons.Inversions.LF_TALON_INVERT);
    LBTalon.setInverted(Constants.Talons.Inversions.LB_TALON_INVERT);
    RFTalon.setInverted(Constants.Talons.Inversions.RF_TALON_INVERT);
    RBTalon.setInverted(Constants.Talons.Inversions.RB_TALON_INVERT);

    LBTalon.follow(LFTalon);
    RBTalon.follow(RFTalon);
  }

  private void set(double leftPower, double rightPower) {
    LFTalon.set(ControlMode.PercentOutput, leftPower * Constants.Talons.Speeds.LF_TALON_SPEED);
    RFTalon.set(ControlMode.PercentOutput, rightPower * Constants.Talons.Speeds.RF_TALON_SPEED);
  }

  public void arcadeDrive(double forward, double rotation, double throttle) {
    set((forward + rotation) * throttle, (forward - rotation) * throttle);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
