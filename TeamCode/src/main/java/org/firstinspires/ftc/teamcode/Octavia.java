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
    public Config cfg;
    public void init(HardwareMap map){
        super.init(map); // Run this first to avoid null-pointer exceptions.

        dbase = new DriveBase(cfg, map);

        /* Note from Toby: I had originally programmed this to test our Board Meeting library,
         * but since Octavia mostly uses motors, we don't actually need any of this code.
         * What we *do* need to do is initialize the IMU.
         */
        //sensors.addItem(map, "touch sensor");
        //sensors.getItem("touch sensor").setMode(DigitalChannel.Mode.INPUT);

        //servos.addItem(map, "servo");

        //analogSensors.addItem(map, "analog sensor");

        //colorSensors.addItem(map, "color sensor");

        //distanceSensors.addItem(map, "distance sensor");

        RevHubOrientationOnRobot orientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
        initializeIMU(orientation);
    }
}
