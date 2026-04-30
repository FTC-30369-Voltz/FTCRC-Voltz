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
        setCommands();
        while (opModeIsActive()){
            autoCommander.runAllQueuedCommands();
            telemetry.update();
        }
    }
    public void setCommands(){
        // From Loading Zone (4 1/3 Seconds)
        autoCommander.addCommand(new IntakeArtifactsCommand(octavia, 1));
        autoCommander.addCommand(new MoveCommand(octavia, 1f));
        autoCommander.addCommand(new TurnCommand(octavia, 0.333f, TurnCommand.TurnDirection.RIGHT));
        autoCommander.addCommand(new ShootArtifactCommand(octavia, 2));
        // 20 2/3 Seconds Remaining...
        // From Bottom Row (5 5/6 Seconds)
        autoCommander.addCommand(new TurnCommand(octavia, 0.167F, TurnCommand.TurnDirection.RIGHT));
        autoCommander.addCommand(new MoveCommand(octavia, 0.5f));
        autoCommander.addCommand(new TurnCommand(octavia, 0.5F, TurnCommand.TurnDirection.LEFT));
        autoCommander.addCommand(new IntakeArtifactsCommand(octavia, 0.75f));
        autoCommander.addCommand(new MoveCommand(octavia, 0.75f));
        autoCommander.addCommand(new TurnCommand(octavia, 0.5F, TurnCommand.TurnDirection.RIGHT));
        autoCommander.addCommand(new IntakeArtifactsCommand(octavia, 0.5f));
        autoCommander.addCommand(new TurnCommand(octavia, 0.167F, TurnCommand.TurnDirection.LEFT));
        autoCommander.addCommand(new ShootArtifactCommand(octavia, 2));
        // 14 5/6 Seconds Remaining...
        // From Middle Row (6 1/3 Seconds)
        autoCommander.addCommand(new TurnCommand(octavia, 0.167F, TurnCommand.TurnDirection.RIGHT));
        autoCommander.addCommand(new MoveCommand(octavia, 1f));
        autoCommander.addCommand(new TurnCommand(octavia, 0.5F, TurnCommand.TurnDirection.LEFT));
        autoCommander.addCommand(new IntakeArtifactsCommand(octavia, 0.75f));
        autoCommander.addCommand(new MoveCommand(octavia, 0.75f));
        autoCommander.addCommand(new TurnCommand(octavia, 0.5F, TurnCommand.TurnDirection.RIGHT));
        autoCommander.addCommand(new IntakeArtifactsCommand(octavia, 1f));
        autoCommander.addCommand(new TurnCommand(octavia, 0.167F, TurnCommand.TurnDirection.LEFT));
        autoCommander.addCommand(new ShootArtifactCommand(octavia, 2));
        // 8 1/2 Seconds Remaining...
    }
}