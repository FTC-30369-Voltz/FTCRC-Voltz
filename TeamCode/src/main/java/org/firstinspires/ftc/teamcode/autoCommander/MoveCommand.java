package org.firstinspires.ftc.teamcode.autoCommander;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

public class MoveCommand extends BotCommand {
    public MoveCommand(ProgramBoard board, float sleepTime) {
        super(board, sleepTime);
    }

    @Override
    public void onInit(ProgramBoard board) {
        super.onInit(board);
        board.dbase.setPower(1, 1);
    }

    @Override
    public void onStop(ProgramBoard board) {
        super.onStop(board);
        board.dbase.setPower(0, 0);
    }
}