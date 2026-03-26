package org.firstinspires.ftc.teamcode.boardmeeting;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Config;

public class DriveBase {
    public DcMotor leftMotor;
    public DcMotor rightMotor;

    public DriveBase(Config cfg, HardwareMap map){
        leftMotor = map.get(DcMotor.class, cfg.DB_TANK_LEFT);
        rightMotor = map.get(DcMotor.class, cfg.DB_TANK_RIGHT);
    }

    public void setMode(DcMotor.RunMode leftMode, DcMotor.RunMode rightMode){
        leftMotor.setMode(leftMode);
        rightMotor.setMode(rightMode);
    }

    public void setPower(double leftPower, double rightPower){
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }
}
