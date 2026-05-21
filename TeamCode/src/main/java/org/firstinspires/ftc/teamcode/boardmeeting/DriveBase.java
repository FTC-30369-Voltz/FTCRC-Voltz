package org.firstinspires.ftc.teamcode.boardmeeting;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Config;

public class DriveBase {
    public DcMotorEx leftMotor;
    public DcMotorEx rightMotor;

    public DriveBase(ProgramBoard board, Config cfg, HardwareMap map){
        leftMotor = board.motors.addItem(map, cfg.DB_TANK_LEFT);
        rightMotor = board.motors.addItem(map, cfg.DB_TANK_RIGHT);
        setDirection(DcMotorSimple.Direction.REVERSE, DcMotorSimple.Direction.REVERSE);
    }

    public void setMode(DcMotor.RunMode leftMode, DcMotor.RunMode rightMode){
        leftMotor.setMode(leftMode);
        rightMotor.setMode(rightMode);
    }

    public void setPower(double leftPower, double rightPower){
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }

    public void setDirection(DcMotorSimple.Direction leftDir, DcMotorSimple.Direction rightDir){
        leftMotor.setDirection(leftDir);
        rightMotor.setDirection(rightDir);
    }
}