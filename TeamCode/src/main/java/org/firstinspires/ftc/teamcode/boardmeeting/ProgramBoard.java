package org.firstinspires.ftc.teamcode.boardmeeting;

// FTC imports
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Config;

/**
* A ProgramBoard. It maps strings to connected hardware for use in multiple different OpModes.
* It's honestly not the approach I would have gone with, but it works.
 */
public class ProgramBoard {
    public Config cfg;

    public DriveBase dbase;

    public DeviceType<DigitalChannel> sensors;
    public DeviceType<DcMotor> motors;
    public DeviceType<Servo> servos;
    public DeviceType<AnalogInput> analogSensors;
    public DeviceType<ColorSensor> colorSensors;
    public DeviceType<DistanceSensor> distanceSensors;

    public IMU imu;

    public void init(HardwareMap map){
        sensors = new DeviceType<>(DigitalChannel.class);
        motors = new DeviceType<>(DcMotor.class);
        servos = new DeviceType<>(Servo.class);
        analogSensors = new DeviceType<>(AnalogInput.class);
        colorSensors = new DeviceType<>(ColorSensor.class);
        distanceSensors = new DeviceType<>(DistanceSensor.class);

        imu = map.get(IMU.class, "imu");
    }
    public void initializeIMU(RevHubOrientationOnRobot orientation){
        imu.initialize(new IMU.Parameters(orientation));
    }
}