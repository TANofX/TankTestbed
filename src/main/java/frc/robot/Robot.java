// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  private final CANSparkMax m_leftDrive1= new CANSparkMax(11, MotorType.kBrushless);
  private final CANSparkMax m_rightDrive1 = new CANSparkMax(12, MotorType.kBrushless);
  private final CANSparkMax m_leftDrive2 = new CANSparkMax(13, MotorType.kBrushless);
  private final CANSparkMax m_rightDrive2 = new CANSparkMax(14, MotorType.kBrushless);

  private final MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftDrive1, m_leftDrive2);
  private final MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightDrive1, m_rightDrive2);

  private DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  private Joystick m_joystick;
  private final PneumaticsControlModule m_module = new PneumaticsControlModule(2);
  private final Solenoid m_Solenoid = m_module.makeSolenoid(2);
  
  @Override
  public void robotInit() {
    m_rightDrive.setInverted(true);
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
    Joystick m_Stick = new Joystick(0);
    m_robotDrive.tankDrive(-m_Stick.getY(), -m_Stick.getX());

    if (m_joystick.getTrigger()) {
      m_Solenoid.toggle();
    }
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
