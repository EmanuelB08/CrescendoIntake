// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  CANSparkMax IntakeMotor = null;
  boolean Note_in = true;

  public Intake() {
    IntakeMotor = new CANSparkMax(0, MotorType.kBrushless);

    configMotors(IntakeMotor);
  }

  public void SpinSpeed(double speed) {
    IntakeMotor.set(speed);
  }

  public void Spin() {
    if(Note_in) {IntakeMotor.set(Constants.INTAKE_MOTOR_SPEED);
  }
}

  public Command rollerSpin(double speed, Intake m_intake) {
    return new InstantCommand(() -> m_intake.SpinSpeed(speed));
  }   

  public void endIntake() {
    IntakeMotor.set(0);
  }
  
  private void configMotors(CANSparkMax IntakeMotor) {
    IntakeMotor.setIdleMode(IdleMode.kBrake);
    IntakeMotor.setSmartCurrentLimit(25);
    IntakeMotor.setInverted(false);

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Speed", IntakeMotor.get());
  }
}
