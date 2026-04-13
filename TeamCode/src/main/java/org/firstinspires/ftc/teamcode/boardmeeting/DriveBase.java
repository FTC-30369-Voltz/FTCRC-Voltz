package org.firstinspires.ftc.teamcode.boardmeeting;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Config;

public class DriveBase {
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    public DriveBase(ProgramBoard board, Config cfg, HardwareMap map){
        leftMotor = board.motors.addItem(map, cfg.DB_TANK_LEFT);
        rightMotor = board.motors.addItem(map, cfg.DB_TANK_RIGHT);
    }

    public void setMode(DcMotor.RunMode leftMode, DcMotor.RunMode rightMode){
        leftMotor.setMode(leftMode);
        rightMotor.setMode(rightMode);
    }

    public void setPower(double leftPower, double rightPower){
        leftMotor.setPower(Math.abs(leftPower));
        rightMotor.setPower(Math.abs(rightPower));
    }

    public void setDirection(double leftPower, double rightPower){
        leftMotor.setDirection(calculateDirection(leftPower));
        rightMotor.setDirection(calculateDirection(rightPower));
    }

    private DcMotorSimple.Direction calculateDirection(double speed) {
        if(speed < 0) {
            return DcMotorSimple.Direction.REVERSE;
        } else {
            return DcMotorSimple.Direction.FORWARD;
        }
    }
}