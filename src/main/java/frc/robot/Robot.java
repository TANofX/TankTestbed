// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private final TalonFX leftPrimary = new TalonFX(1, "rio");
  private final TalonFX leftSecondary = new TalonFX(3, "rio");
  private final TalonFX rightPrimary = new TalonFX(2, "rio");
  private final TalonFX rightSecondary = new TalonFX(4, "rio");

  private final MotorControllerGroup leftGroup = new MotorControllerGroup(leftPrimary, leftSecondary);
  private final MotorControllerGroup rightGroup = new MotorControllerGroup(rightPrimary, rightSecondary);

  private final Joystick leftStick = new Joystick(0);
  private final Joystick rightStick = new Joystick(1);

  private final DifferentialDrive driveTrain = new DifferentialDrive(leftGroup, rightGroup);

  private final PneumaticsControlModule pcm = new PneumaticsControlModule(2);
  private Solenoid blackSolenoid;
  private boolean lastTrigger;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    rightGroup.setInverted(true);

    pcm.enableCompressorDigital();
    blackSolenoid = pcm.makeSolenoid(2);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    if (!rightStick.getTrigger()) {
      driveTrain.tankDrive(-leftStick.getY(), -rightStick.getY(), true);
    }
    
    if (leftStick.getTrigger() && !lastTrigger) {
      blackSolenoid.set(blackSolenoid.get());
    }

    lastTrigger = leftStick.getTrigger();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
