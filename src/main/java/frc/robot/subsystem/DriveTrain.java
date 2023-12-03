// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystem;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final TalonFX leftPrimary = new TalonFX(1, "rio");
  private final TalonFX leftSecondary = new TalonFX(2, "rio");
  private final TalonFX rightPrimary = new TalonFX(3, "rio");
  private final TalonFX rightSecondary = new TalonFX(4, "rio");

  private MotorControllerGroup leftGroup = new MotorControllerGroup(leftPrimary, leftSecondary);
  private MotorControllerGroup rightGroup = new MotorControllerGroup(rightPrimary, rightSecondary);

  private DifferentialDrive driveControl = new DifferentialDrive(leftGroup, rightGroup);
  /** Creates a new DriveTrain. */
  public DriveTrain() {
    rightGroup.setInverted(true);
  }

  public void tank(double leftSpeed, double rightSpeed) {
    driveControl.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
