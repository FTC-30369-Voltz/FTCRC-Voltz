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
        telemetry.addData("Left motor", gamepad1.left_stick_x);
        telemetry.addData("Right motor", gamepad1.right_stick_x);
        float leftMotor = gamepad1.left_stick_x;
        float rightMotor = gamepad1.right_stick_x;
        /*
        * Each control stick's X axis should control its corresponding motor on
        * the drive base (which is tank drive btw). The goal is also to get it
        * so that holding down a trigger on the gamepad will also spin the motors
        * on the ITO (save for the outtake motor, which would be controlled by
        * something else).
        */
        float totalPower = (float) Math.sqrt(Math.abs(leftMotor+rightMotor));
        if (totalPower > 0) {
            //octavia.dbase.setDirection(leftMotor, rightMotor);
            //octavia.dbase.setPower(leftMotor, rightMotor);
        }
        float intake = gamepad1.right_trigger;
        float transfer = gamepad1.left_trigger;
        boolean shoot = gamepad1.right_bumper;
        boolean itoNeutral = intake == 0 && transfer == 0 && !shoot;
        if (itoNeutral) {
            octavia.ito.itoIdle();
        } else {
            if (intake > 0){
                octavia.ito.intakeArtifact(intake/2);
            }
            if (transfer > 0){
                octavia.ito.transferArtifact(transfer/2);
            }
            if (shoot){
                octavia.ito.shootArtifact();
            }
        }
    }
}