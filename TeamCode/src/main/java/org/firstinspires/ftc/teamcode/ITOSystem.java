package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class ITOSystem {
    public DcMotorEx intake;
    public DcMotorEx transfer;

    /*
    * outtakeLeft and outtakeRight correspond to the perspective of
    * Artifacts exiting the transfer system.
    */
    public DcMotorEx outtakeLeft;
    public DcMotorEx outtakeRight;

    public boolean turboMode;
    public ITOSystem(Octavia board, Config cfg, HardwareMap map){
        intake = board.motors.addItem(map, cfg.ITO_INTAKE);
        transfer = board.motors.addItem(map,cfg.ITO_TRANSFER);
        outtakeLeft = board.motors.addItem(map, cfg.ITO_OUTTAKE_L);
        outtakeRight = board.motors.addItem(map, cfg.ITO_OUTTAKE_R);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        transfer.setDirection(DcMotorSimple.Direction.REVERSE);
        outtakeLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        outtakeRight.setDirection(DcMotorSimple.Direction.REVERSE);
        turboMode = cfg.turboMode;
    }

    public void itoIdle() {
        intake.setPower(0);
        transfer.setPower(0);
        if (turboMode) {
            outtakeLeft.setPower(0);
            outtakeRight.setPower(0);
        } else {
            outtakeLeft.setVelocity(0);
            outtakeRight.setVelocity(0);
        }
    }

    public void intakeArtifact(float power){
        intake.setPower(power);
    }

    public void transferArtifact(float power){
        transfer.setPower(power);
    }

    public void shootArtifact(boolean tm){
        turboMode = tm;
        if (turboMode) {
            double turns_per_second = (6000f/60)*(21); //(6000 RPM/60) * (28 ticks * 1:2 ratio)
            outtakeLeft.setVelocity(turns_per_second);
            outtakeRight.setVelocity(turns_per_second);
        } else {
            outtakeLeft.setPower(1);
            outtakeRight.setPower(1);
        }
    }
}