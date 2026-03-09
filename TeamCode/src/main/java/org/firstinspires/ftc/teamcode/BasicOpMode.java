package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class BasicOpMode extends OpMode {

    Octavia octavia = new Octavia();

    @Override
    public void init() {
        octavia.init(hardwareMap);
    }

    @Override
    public void loop(){
        telemetry.addData("Hello", "World");
    }
}
