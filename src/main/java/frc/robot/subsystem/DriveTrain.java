// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final CANSparkMax leftPrimary = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax leftSecondary = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax rightPrimary = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax rightSecondary = new CANSparkMax(4, MotorType.kBrushless);

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
