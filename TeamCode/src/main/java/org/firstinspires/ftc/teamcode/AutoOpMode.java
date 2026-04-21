package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.autoCommander.AutoCommander;

@Autonomous
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
            autoCommander.runAllQueuedCommands();
            telemetry.update();
        }
    }
}