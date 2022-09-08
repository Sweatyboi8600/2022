// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  TalonSRX LFTalon, LBTalon, RFTalon, RBTalon;

  // Ultrasonic LUltrasonic, RUltrasonic;
  
  AnalogInput left, right;

  // AnalogGyro gyro;
  ADXRS450_Gyro gyro;

  NetworkTableEntry gyroEntry;

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



    left = new AnalogInput(0);
    right = new AnalogInput(1);

    // gyro = new AnalogGyro(Constants.Sensors.Gyros.Port.port);
    gyro = new ADXRS450_Gyro();
    gyro.reset();

    // ShuffleboardTab tab = Shuffleboard.getTab("test");
    // gyroEntry = tab.addPersistent("asdf", 0).withWidget(BuiltInWidgets.kGyro).getEntry();
  }

  public void set(double leftPower, double rightPower) {
    LFTalon.set(ControlMode.PercentOutput, leftPower);
    LBTalon.set(ControlMode.PercentOutput, leftPower);
    RFTalon.set(ControlMode.PercentOutput, rightPower);
    RBTalon.set(ControlMode.PercentOutput, rightPower);
  }

  public void arcadeDrive(double forward, double rotation, double throttle) {
    set((forward - rotation) * throttle * Constants.Talons.Speeds.DRIVE_TALON_SPEED,
        (forward + rotation) * throttle * Constants.Talons.Speeds.DRIVE_TALON_SPEED);
  }

  public double getLeftDistance() { 
    if (left == null) return 0;
    return left.getValue();
  }

  public double getRightDistance() {
    if (right == null) return 0;
    return right.getValue();
  }

  public double getDistance() {
    return getLeftDistance();
    // return Math.min(getLeftDistance(), getRightDistance());
  }

  public double getRotation() {
    if (gyro == null) return 0;
    return gyro.getAngle();
  }




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // SmartDashboard.putNumber("Ultransonics", getDistance());
    SmartDashboard.putNumber("Ultrasonic Sensor L", getLeftDistance());
    SmartDashboard.putNumber("Ultrasonic Sensor R", getRightDistance());
    // SmartDashboard.putNumber("Gyro", getRotation());
    SmartDashboard.putData("Gyro", gyro);
  }
}
