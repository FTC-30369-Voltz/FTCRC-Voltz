package org.firstinspires.ftc.teamcode.autoCommander;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

public class ShootArtifactCommand extends BotCommand {
    public ShootArtifactCommand(ProgramBoard board, float sleepTime) {
        super(board, sleepTime);
    }

    @Override
    public void onInit(ProgramBoard board) {
        super.onInit(board);
        double turns_per_second = (6000f/60)*(21); //(6000 RPM/60) * (28 ticks * 1:2 ratio)
        board.motors.getItem(board.cfg.ITO_INTAKE).setPower(1);
        board.motors.getItem(board.cfg.ITO_TRANSFER).setPower(1);
        board.motors.getItem(board.cfg.ITO_OUTTAKE_L).setVelocity(turns_per_second);
        board.motors.getItem(board.cfg.ITO_OUTTAKE_R).setVelocity(turns_per_second);
    }

    @Override
    public void onStop(ProgramBoard board) {
        super.onStop(board);
        board.motors.getItem(board.cfg.ITO_INTAKE).setPower(0);
        board.motors.getItem(board.cfg.ITO_TRANSFER).setPower(0);
        board.motors.getItem(board.cfg.ITO_OUTTAKE_L).setVelocity(0);
        board.motors.getItem(board.cfg.ITO_OUTTAKE_R).setVelocity(0);
    }
}