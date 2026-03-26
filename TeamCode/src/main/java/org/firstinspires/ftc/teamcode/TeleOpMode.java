package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOpMode extends OpMode {

    Octavia octavia = new Octavia();

    @Override
    public void init() {
        octavia.init(hardwareMap);
    }

    @Override
    public void loop(){
        telemetry.addData("Hello", "World");
        telemetry.addData("Left stick X", gamepad1.left_stick_x);
        telemetry.addData("Left stick Y", gamepad1.left_stick_y);

    }
}
