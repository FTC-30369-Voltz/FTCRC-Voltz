package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

public class ITOSystem {
    public DcMotor intake;
    public DcMotor transfer;

    /*
    * outtakeLeft and outtakeRight correspond to the perspective of
    * Artifacts exiting the transfer system.
    */
    public DcMotor outtakeLeft;
    public DcMotor outtakeRight;
    public ITOSystem(ProgramBoard board, Config cfg, HardwareMap map){
        intake = board.motors.addItem(map, cfg.ITO_INTAKE);
        transfer = board.motors.addItem(map,cfg.ITO_TRANSFER);
        outtakeLeft = board.motors.addItem(map, cfg.ITO_OUTTAKE_L);
        outtakeRight = board.motors.addItem(map, cfg.ITO_OUTTAKE_R);
        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        transfer.setDirection(DcMotorSimple.Direction.FORWARD);
        outtakeLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        outtakeRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void itoIdle() {
        intake.setPower(0);
        transfer.setPower(0);
        outtakeLeft.setPower(0);
        outtakeRight.setPower(0);
    }

    public void intakeArtifact(float power){
        intake.setPower(power);
    }

    public void transferArtifact(float power){
        transfer.setPower(power);
    }

    public void shootArtifact(){
        outtakeLeft.setPower(1);
        outtakeRight.setPower(1);
    }
}