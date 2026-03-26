package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.boardmeeting.DriveBase;
import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

/**
 * Octavia's programming board setup.
 */
public class Octavia extends ProgramBoard
{
    public DcMotor ito_transfer;
    public DcMotor ito_outtake_L;
    public DcMotor ito_outtake_R;

    public void init(HardwareMap map){
        super.init(map); // Run this first to avoid null-pointer exceptions.

        dbase = new DriveBase(cfg, map);

        ito_transfer = motors.addItem(map, cfg.ITO_TRANSFER);
        ito_outtake_L = motors.addItem(map, cfg.ITO_OUTTAKE_L);
        ito_outtake_R = motors.addItem(map, cfg.ITO_OUTTAKE_R);
        RevHubOrientationOnRobot orientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
        initializeIMU(orientation);
    }
}
