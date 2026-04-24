package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.autoCommander.AutoCommander;
import org.firstinspires.ftc.teamcode.autoCommander.IntakeArtifactsCommand;
import org.firstinspires.ftc.teamcode.autoCommander.MoveCommand;
import org.firstinspires.ftc.teamcode.autoCommander.ShootArtifactCommand;
import org.firstinspires.ftc.teamcode.autoCommander.TurnCommand;

@Autonomous
public class AutoBlue extends LinearOpMode {
    Octavia octavia = new Octavia();
    AutoCommander autoCommander;
    @Override
    public void runOpMode(){
        octavia.init(hardwareMap);
        autoCommander = new AutoCommander(octavia);
        telemetry.update();
        waitForStart();
        collectPlacedArtifacts();
        while (opModeIsActive()){
            autoCommander.runOldestQueuedCommand();
            telemetry.update();
        }
    }
    public void collectPlacedArtifacts(){
        autoCommander.addCommand(new IntakeArtifactsCommand(octavia, 1));
        autoCommander.addCommand(new MoveCommand(octavia, 3));
        autoCommander.addCommand(new TurnCommand(octavia, 1, TurnCommand.TurnDirection.LEFT));
        autoCommander.addCommand(new MoveCommand(octavia, 2));
        autoCommander.addCommand(new TurnCommand(octavia, 0.5F, TurnCommand.TurnDirection.LEFT));
        autoCommander.addCommand(new ShootArtifactCommand(octavia, 3));
    }
}