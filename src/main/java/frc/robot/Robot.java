// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    private final TalonFX m_leftMotor1 = new TalonFX(0);
    private final TalonFX m_rightMotor1 = new TalonFX(1);
    private final TalonFX m_leftMotor2 = new TalonFX(3);
    private final TalonFX m_rightMotor2 = new TalonFX(4);

    private MotorControllerGroup leftMotors = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
        private MotorControllerGroup rightMotors = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);


    private final DifferentialDrive drives = new DifferentialDrive(leftMotors, rightMotors);

    private final XboxController controller = new XboxController(0);

    private Joystick verticalStick = new Joystick(0);
    private Joystick horizontalStick = new Joystick(1);

    
   
    //private final Timer m_timer = new Timer();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    rightMotors.setInverted(true);

   
     
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
    //read button and joystick/solenoid
    
      drives.arcadeDrive(verticalStick.getY(), 0);
   
    
      drives.arcadeDrive(verticalStick.getY(), 0);

  
    drives.arcadeDrive(0, horizontalStick.getX() );


  drives.arcadeDrive(0, horizontalStick.getX());

  
 
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
