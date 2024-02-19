// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake2 extends SubsystemBase {
  /** Creates a new Intake2. */
  CANSparkMax OTBMotor1 = null;
  CANSparkMax OTBMotor2 = null;
  Encoder pivotEncoder = null; 

  public Intake2() {
    OTBMotor1 = new CANSparkMax(0, MotorType.kBrushless);
    OTBMotor2 = new CANSparkMax(0, MotorType.kBrushless);

    pivotEncoder = new Encoder(0, 0);

    configMotors(OTBMotor1, OTBMotor2);
  }
 

  private void configMotors(CANSparkMax OTBMotor1, CANSparkMax OTBMotor2) {
    CANSparkMax[] motors = {OTBMotor1, OTBMotor2};
    for (CANSparkMax motor : motors) {
      motor.setIdleMode(IdleMode.kBrake);
      motor.setSmartCurrentLimit(20); //
    }

  }

  public double pivotAngle() {
    double angle = getEncoderPosition();
    if(angle < 0) {
      angle += 360;
    }
    return angle;
  }

  public double getEncoderPosition() {
    return pivotEncoder.getDistance();
  }

  public double getEncoderVelocity() {
    return pivotEncoder.getRate();
  }

  public double getMotorVelocity() {
    return OTBMotor1.getEncoder().getVelocity(); //
  }

  public void motorSpeeds() {
    OTBMotor1.set(Constants.OTB_MOTOR_ONE_SPEED);
    OTBMotor2.set(Constants.OTB_MOTOR_TWO_SPEED);

  }

  public void endMotors() {
    OTBMotor1.set(0);
    OTBMotor2.set(0);

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("OTB Encoder", getEncoderPosition()); //
    SmartDashboard.putNumber("First OTB Motor Speed", OTBMotor1.get());
    SmartDashboard.putNumber("Second OTB Motor Speed", OTBMotor2.get());

  }
}

