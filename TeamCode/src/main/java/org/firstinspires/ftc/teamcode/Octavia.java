package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.boardmeeting.DriveBase;
import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

/**
 * Octavia's programming board setup.
 */
public class Octavia extends ProgramBoard
{
    public ITOSystem ito;

    public void init(HardwareMap map){
        super.init(map); // Run this first to avoid null-pointer exceptions when initializing the IMU.

        cfg = new Config();

        dbase = new DriveBase(this, cfg, map);
        ito = new ITOSystem(this, cfg, map);

        RevHubOrientationOnRobot orientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
        initializeIMU(orientation);
    }
}