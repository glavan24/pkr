// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Shooter;

public class TeleopLaunchNote extends Command {
  private final Shooter m_shooter;
  private final Intake m_intake;

  public TeleopLaunchNote(Shooter shooter, Intake intake) {
    m_shooter = shooter;
    m_intake = intake;

    addRequirements(m_shooter, m_intake);
  }

  
  @Override
  public void initialize() {
  // Called when the command is initially scheduled.
    // Start up launch motors
    m_shooter.ShooterRun(Constants.kShooterLaunch);
    // get up to steady speed
    Timer.delay(0.5);
    // start up intake motor
    m_intake.IntakeRun(Constants.kIntakeIn);
    // wait for note to launch
    Timer.delay(0.5);
    //stop all motors
    m_intake.IntakeStop(); 
    m_shooter.ShooterStop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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