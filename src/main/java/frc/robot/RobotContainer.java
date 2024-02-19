// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake2;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

 
public class RobotContainer {

  private Intake m_intake;
  private Intake2 m_intake2;
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings

    
    configureBindings();


  }

  private void configureBindings() {
    // // TODO Auto-generated method stub 

    //Intake
    m_driverController.leftBumper().onTrue(new InstantCommand(() -> m_intake.Spin()));
    m_driverController.rightBumper().onFalse(new InstantCommand(() -> m_intake.endIntake()));

    //Yoshi
    m_driverController.leftTrigger().onTrue(new InstantCommand(() -> m_intake2.motorSpeeds()));
    m_driverController.rightTrigger().onTrue(new InstantCommand(() -> m_intake2.endMotors()));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  }

