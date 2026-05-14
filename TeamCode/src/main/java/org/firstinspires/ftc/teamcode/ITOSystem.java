package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

public class ITOSystem {
    public DcMotorEx intake;
    public DcMotorEx transfer;

    /*
    * outtakeLeft and outtakeRight correspond to the perspective of
    * Artifacts exiting the transfer system.
    */
    public DcMotorEx outtakeLeft;
    public DcMotorEx outtakeRight;
    public ITOSystem(ProgramBoard board, Config cfg, HardwareMap map){
        intake = board.motors.addItem(map, cfg.ITO_INTAKE);
        transfer = board.motors.addItem(map,cfg.ITO_TRANSFER);
        outtakeLeft = board.motors.addItem(map, cfg.ITO_OUTTAKE_L);
        outtakeRight = board.motors.addItem(map, cfg.ITO_OUTTAKE_R);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        transfer.setDirection(DcMotorSimple.Direction.REVERSE);
        outtakeLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        outtakeRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void itoIdle() {
        intake.setPower(0);
        transfer.setPower(0);
        outtakeLeft.setVelocity(0);
        outtakeRight.setVelocity(0);
    }

    public void intakeArtifact(float power){
        intake.setPower(power);
    }

    public void transferArtifact(float power){
        transfer.setPower(power);
    }

    public void shootArtifact(){
        double turns_per_second = (6000f/60)*(14); //(6000 RPM/60) * (28 ticks * 1:2 ratio (b/c_)
        outtakeLeft.setVelocity(turns_per_second);
        outtakeRight.setVelocity(turns_per_second);
    }
}