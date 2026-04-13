package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.autoCommander.AutoCommander;

@TeleOp
public class AutoOpMode extends LinearOpMode {
    Octavia octavia = new Octavia();
    AutoCommander autoCommander;
    @Override
    public void runOpMode(){
        octavia.init(hardwareMap);
        autoCommander = new AutoCommander(octavia);
        telemetry.update();
        waitForStart();
        while (opModeIsActive()){
            telemetry.update();
        }
    }
}