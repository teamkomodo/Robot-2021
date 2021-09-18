package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import frc.robot.core.Globals;
import frc.robot.core.OI;
import com.revrobotics.ControlType;
public final class Autonomous {
    double sA;
    public VisionRange visionRangeFunction;
    public Vision visionFunction;

    public Autonomous() {
        switch (Globals.autonomous_stage) {
            case 0:
                //1 foot = 9464.56 on left
                if (OI.motor1.getSelectedSensorPosition(0) > -9464.7 * 5) {
                    OI.drive.arcadeDrive(-.5, sA);
                    OI.ta = OI.table.getEntry("ta");
                    OI.la = OI.ta.getDouble(0.0);
                    sA = OI.navx.getAngle() * .09;
                    if (OI.navx.getAngle() < 1.75 && OI.navx.getAngle() > -1.75) {
                        sA *= 4.20;
                        Globals.LEDmode = 10;
                    } else {
                        Globals.LEDmode = 2;
                    }

                    if (sA > 1) {
                        sA = 1;
                    } else if (sA < -1) {
                        sA = -1;
                    }
                } else {
                    visionFunction = new Vision(.975, 0, 1.0);
                    OI.shooterPIDcontroller1.setReference(2800, ControlType.kVelocity);
                    OI.shooterPIDcontroller2.setReference(-2800, ControlType.kVelocity);
                    if (OI.shooter_encoder1.getVelocity() + 500 > 2800 && OI.shooter_encoder1.getVelocity() - 500 < 2800) {
                        if (!Globals.intake_flag) {
                            OI.Limelight_timer.start();
                            OI.shotclock_timer.start();
                            Globals.intake_flag = true;
                        }
                        if (OI.shotclock_timer.get() > .5) {
                            if (Globals.shooter_lineup) {
                                Globals.anticlogtimer_flag = false;
                                OI.anitclog_timer.reset();
                                Globals.RPM_good = true;
                                OI.shooter_intake.set(-.9);
                                if (!Globals.intaketimer_flag) {
                                    OI.intake_timer.start();
                                    Globals.intaketimer_flag = true;
                                }
                                if (OI.intake_timer.get() > .1) {
                                    OI.hopper_motor.set(TalonSRXControlMode.PercentOutput, .3);
                                }
                            }
                        } else {
                            Globals.RPM_good = false;
                            OI.shooter_intake.set(0);
                            OI.hopper_motor.set(TalonSRXControlMode.PercentOutput, 0);
                        }
                    } else {
                        if (!Globals.anticlogtimer_flag) {
                            OI.anitclog_timer.start();
                            Globals.anticlogtimer_flag = true;
                        }
                    }
                }

                if (Globals.ball_counter == 0) {
                    OI.shooterPIDcontroller1.setReference(0, ControlType.kVelocity);
                    OI.shooterPIDcontroller2.setReference(0, ControlType.kVelocity);
                    OI.shooter_intake.set(0);
                    OI.hopper_motor.set(TalonSRXControlMode.PercentOutput, 0);
                    Globals.autonomous_stage++;
                }

                break;
            case 1:
                OI.drive.tankDrive(0, 0);
                Globals.autonomous_stage++;
                break;
            // case 2:
            //     sA = 140-OI.navx.getAngle()*.09;
            //     if(OI.navx.getAngle()<-20-2){
            //         OI.drive.arcadeDrive(0, -.6);
            //         Globals.LEDmode=2;
            //     } else if(OI.navx.getAngle()>-20+2){
            //         OI.drive.arcadeDrive(0, .6);
            //         Globals.LEDmode=2;
            //     } else {
            //         OI.drive.tankDrive(0, 0);
            //         Globals.LEDmode=10;
            //         Globals.autonomous_stage++;
            //     }
            //         break;
            // case 3:
            //         ball_cycle=new ball cycle;
            default:
                OI.drive.tankDrive(0, 0);
        }
    }
}