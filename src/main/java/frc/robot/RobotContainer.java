// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.command.DefaultDrive;
import frc.robot.subsystem.DriveTrain;
import frc.robot.subsystem.Piston;

public class RobotContainer {
  private static final PneumaticsControlModule pcm = new PneumaticsControlModule(2);

  public static final DriveTrain drives = new DriveTrain();
  public static final Piston blackPiston = new Piston(pcm, 2);

  public final Joystick leftStick = new Joystick(0);
  public final Joystick rightStick = new Joystick(1);


  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    drives.setDefaultCommand(new DefaultDrive(() -> leftStick.getY(), () -> rightStick.getY()));

    (new JoystickButton(leftStick, 1)).onTrue(Commands.runOnce(blackPiston::toggle));
    (new JoystickButton(rightStick, 1)).whileTrue(Commands.run(() -> {}, drives));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
