package frc.robot.core;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.ControlType;
import frc.robot.commands.*;

public final class JoystickControls {

    public Vision vision;
    public String driveFunc(String name) {
        switch (name) {
            case "tankDrive":
                OI.drive.tankDrive(OI.lJoystick.getRawAxis(RobotMap.L_JOYSTICK_Y), OI.rJoystick.getRawAxis(RobotMap.R_JOYSTICK_Y));
                break;
            case "arcadeDrive":
                OI.drive.arcadeDrive(OI.rJoystick.getRawAxis(RobotMap.L_JOYSTICK_Y), -OI.rJoystick.getRawAxis(RobotMap.L_JOYSTICK_X));
                break;
            case "orchestraDrive":
                 OI.mainOrchestra.play();
                 break;
        }
        return name;
    }

    public void intakeFunc() {
     if (OI.gamepad.getRawButtonPressed(RobotMap.A_BUTTON)) {
            OI.intake_motor.set(ControlMode.PercentOutput, 0.75);
            OI.hopper_motor.set(ControlMode.PercentOutput, .6);

        } else if (OI.gamepad.getRawButtonPressed(RobotMap.B_BUTTON)) {
            OI.intake_motor.set(ControlMode.PercentOutput, -.8);
            OI.hopper_motor.set(ControlMode.PercentOutput, -.6);
        }
    if (OI.gamepad.getRawButtonReleased(RobotMap.A_BUTTON)) {
        OI.intake_motor.set(ControlMode.PercentOutput, 0);
        OI.hopper_motor.set(ControlMode.PercentOutput, 0);
    } else if (OI.gamepad.getRawButtonReleased(RobotMap.B_BUTTON)) {
        OI.intake_motor.set(ControlMode.PercentOutput, 0);
        OI.hopper_motor.set(ControlMode.PercentOutput, 0);
    }
    }
    public void shooterFunc(){
        if(OI.gamepad.getRawButtonPressed(RobotMap.X_BUTTON)){
            System.out.println("X");
            OI.shooterPIDcontroller1.setReference(5000, ControlType.kVelocity);
            OI.shooterPIDcontroller2.setReference(-5000, ControlType.kVelocity);// Not Working
            OI.shooterintakePID.setReference(-1000, ControlType.kVelocity);
        } else if(OI.gamepad.getRawButtonReleased(RobotMap.X_BUTTON)){
            OI.shooter_motor1.set(0);
            OI.shooter_motor2.set(0);
            OI.shooter_intake.set(0);
        }
    }

    public void climberFunc() {
        if(OI.gamepad.getRawButtonPressed(RobotMap.L_TRIGGER)) {
            OI.cL_timer.start();
            OI.cl_upL.set(ControlMode.PercentOutput, 0.5);
        } else if (OI.cL_timer.get() > 1) {
            OI.cl_upL.set(ControlMode.PercentOutput, 0);
        }
        if(OI.gamepad.getRawButtonPressed(RobotMap.R_TRIGGER)) {
            OI.cR_timer.start();
            OI.cl_upR.set(ControlMode.PercentOutput, 0.5);
        } else if (OI.cL_timer.get() > 1) {
            OI.cl_upR.set(ControlMode.PercentOutput, 0);
        }
    }

    public void visionFunc(){
        if (OI.rJoystick.getRawButtonPressed(RobotMap.R_TRIGGER)) {
            OI.swivle.setAngle(5);
            vision = new Vision(.975,0,1.0, -3);
            Globals.UserControl = false;
            OI.shooterPIDcontroller1.setReference(Globals.Vilocity1,  ControlType.kVelocity);
            OI.shooterPIDcontroller2.setReference(-Globals.Vilocity1, ControlType.kVelocity);
            if(OI.shooter_encoder1.getVelocity() + 300 >= Globals.Vilocity1 && OI.shooter_encoder1.getVelocity() - 300 <= Globals.Vilocity1){
                if(!Globals.intake_flag){
                    OI.Limelight_timer.start();
                    OI.shotclock_timer.start();
                    Globals.intake_flag = true;
                }
                if(OI.shotclock_timer.get() > 2){
                    if(Globals.shooter_lineup){
                        Globals.anticlogtimer_flag = false;
                        OI.anitclog_timer.reset();
                        Globals.RPM_good = true;
                        Globals.target_covered = true;
                        if(!Globals.anticlogtimer_flag){
                                if(!Globals.antianti_flag){
                                    OI.shooter_intake.set(.2);
                                    OI.anitclog_timer.start();
                                    Globals.antianti_flag = true;
                                }else{
                                    OI.shooter_intake.set(-1);
                                }
                                
                            }
                        
                        if(!Globals.intaketimer_flag){
                            OI.intake_timer.start();
                            Globals.intaketimer_flag = true;
                        }
                        if(OI.intake_timer.get() > 1){
                            if(Globals.distance_to_target > 15){
                                    OI.hopper_motor.set(ControlMode.PercentOutput, .7);
                            }else{
                                    OI.hopper_motor.set(ControlMode.PercentOutput,1);
                            }   
                        }
                    }   
                }else{
                    Globals.RPM_good = false;
                    OI.shooter_intake.set(0);
                    Globals.anticlogtimer_flag = false;
                    Globals.antianti_flag = false;
                    OI.hopper_motor.set(ControlMode.PercentOutput,0);
                }
            }else{
                if(Globals.distance_to_target > 15){
                    OI.shotclock_timer.reset();
                }
                if(!Globals.anticlogtimer_flag){
                    OI.anitclog_timer.start();
                    Globals.anticlogtimer_flag = true; 
                }
                if(OI.anitclog_timer.get() < .25){
                    //    OI.shooter_intake.set(.25);
                }
            }
        }
    }

}