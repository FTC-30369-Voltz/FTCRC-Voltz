package org.firstinspires.ftc.teamcode.boardmeeting;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Config;

public class DriveBase {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public DriveBase(Config cfg, HardwareMap map){
        frontLeft = map.get(DcMotor.class, cfg.DB_FRONT_LEFT);
        frontRight = map.get(DcMotor.class, cfg.DB_FRONT_RIGHT);
        backLeft = map.get(DcMotor.class, cfg.DB_BACK_LEFT);
        backRight = map.get(DcMotor.class, cfg.DB_BACK_RIGHT);
    }
}
