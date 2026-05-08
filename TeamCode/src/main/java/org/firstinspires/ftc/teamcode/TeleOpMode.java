package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeleOpMode extends OpMode {

    Octavia octavia = new Octavia();

    @Override
    public void init() {
        telemetry.addData("Octavia's Status", "Initializing hardware...");
        octavia.init(hardwareMap);
        telemetry.addData("Octavia's Status", "Hardware initialized!");
    }

    @Override
    public void loop(){
        telemetry.addData("Left motor", -gamepad1.left_stick_y);
        telemetry.addData("Right motor", -gamepad1.right_stick_y);
        float leftMotor = gamepad1.left_stick_y;
        float rightMotor = gamepad1.right_stick_y;
        float intake = gamepad1.right_trigger;
        float transfer = gamepad1.left_trigger;
        boolean shoot = gamepad1.right_bumper;
        boolean itoNeutral = intake == 0 && transfer == 0 && !shoot;
        /*
        * Each control stick's X axis should control its corresponding motor on
        * the drive base (which is tank drive btw). The goal is also to get it
        * so that holding down a trigger on the gamepad will also spin the motors
        * on the ITO (save for the outtake motor, which would be controlled by
        * something else).
        */
        float totalPower = (float) Math.sqrt(Math.abs((leftMotor+rightMotor)/2));
        if (totalPower > 0) {
            // Will comment for ITO testing. TODO: See if we can fix this.
            if (itoNeutral) {
                telemetry.addData("Octavia's Status", "Driving...");
            }
            octavia.dbase.setPower(leftMotor, rightMotor);
        } else {
            octavia.dbase.setPower(0, 0);
        }

        if (itoNeutral) {
            octavia.ito.itoIdle();
            telemetry.addData("Octavia's Status", "Active");
        } else {
            if (intake > 0){
                telemetry.addData("Octavia's Status", "Collecting Artifacts...");
                octavia.ito.intakeArtifact(intake/2);
            }
            if (transfer > 0){
                telemetry.addData("Octavia's Status", "Priming Artifacts for launch...");
                octavia.ito.transferArtifact(transfer/2);
            }
            if (shoot){
                telemetry.addData("Octavia's Status", "Launching Artifacts...");
                octavia.ito.shootArtifact();
            }
        }
    }
}