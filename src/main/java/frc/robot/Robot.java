// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private final CANSparkMax m_backleftDrive = new CANSparkMax(12,MotorType.kBrushless);
  private final CANSparkMax m_backrightDrive = new CANSparkMax(13, MotorType.kBrushless);
  private final CANSparkMax m_frontleftDrive = new CANSparkMax(11, MotorType.kBrushless);
  private final CANSparkMax m_frontrightDrive = new CANSparkMax(14, MotorType.kBrushless);
  private final Joystick m_stick = new Joystick(0);
  private final MotorControllerGroup rightDrive = new MotorControllerGroup(m_backrightDrive, m_frontrightDrive);
  private final MotorControllerGroup leftDrive = new MotorControllerGroup(m_backleftDrive, m_frontleftDrive);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(leftDrive, rightDrive);
  private final Timer m_timer = new Timer();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    m_timer.restart();
  }

  @Override
  public void autonomousPeriodic() {
    //Drive for two seconds
    if (m_timer.get() < 2.0) {
    // Drive forwards half speed, make sure to turn input squaring off
    m_robotDrive.arcadeDrive(0.5, 00, false);
  } else {
m_robotDrive.stopMotor(); // stop robot
  }
}
  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
  m_robotDrive.arcadeDrive(-m_stick.getY(), -m_stick.getX());
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
