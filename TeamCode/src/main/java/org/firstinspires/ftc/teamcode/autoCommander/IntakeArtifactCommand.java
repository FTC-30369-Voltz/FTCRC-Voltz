package org.firstinspires.ftc.teamcode.autoCommander;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

public class IntakeArtifactCommand extends BotCommand {
    public IntakeArtifactCommand(ProgramBoard board, float sleepTime) {
        super(board, sleepTime);
    }

    @Override
    public void onInit(ProgramBoard board) {
        super.onInit(board);
        board.motors.getItem(board.cfg.ITO_INTAKE).setPower(1);
        board.motors.getItem(board.cfg.ITO_TRANSFER).setPower(1);
        board.dbase.setPower(-1, -1);
    }

    @Override
    public void onStop(ProgramBoard board) {
        super.onStop(board);
        board.motors.getItem(board.cfg.ITO_INTAKE).setPower(0);
        board.motors.getItem(board.cfg.ITO_TRANSFER).setPower(0);
        board.dbase.setPower(0, 0);
    }
}