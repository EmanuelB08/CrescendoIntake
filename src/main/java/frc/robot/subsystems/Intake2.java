// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake2 extends SubsystemBase {
  /** Creates a new Intake2. */
  CANSparkMax OTBMotor = null;

  public Intake2() {
    OTBMotor = new CANSparkMax(0, MotorType.kBrushless);

  }

  public void powerRollers() {
    OTBMotor.set(Constants.OTB_MOTOR_SPEED);

  }

  public void endRollers() {
    OTBMotor.set(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
