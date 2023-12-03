// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.command;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DefaultDrive extends CommandBase {
  private DoubleSupplier leftSupplier;
  private DoubleSupplier rightSupplier;

  /** Creates a new DefaultDrive. */
  public DefaultDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drives);
  }

  public DefaultDrive(DoubleSupplier left, DoubleSupplier right) {
    this();

    leftSupplier = left;
    rightSupplier = right;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.drives.tank(-leftSupplier.getAsDouble(), -rightSupplier.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
