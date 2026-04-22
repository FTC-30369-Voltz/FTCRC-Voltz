package org.firstinspires.ftc.teamcode.autoCommander;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

public class TurnCommand extends BotCommand {
    public enum TurnDirection {
        LEFT,
        RIGHT
    }
    public TurnDirection direction;
    public TurnCommand(ProgramBoard board, float sleepTime, TurnDirection dir) {
        super(board, sleepTime);
        this.direction = dir;
    }

    @Override
    public void onInit(ProgramBoard board) {
        super.onInit(board);
        if (this.direction == TurnDirection.LEFT) {
            board.dbase.setPower(1, -1);
        } else if (this.direction == TurnDirection.RIGHT) {
            board.dbase.setPower(-1, 1);
        }
    }

    @Override
    public void onStop(ProgramBoard board) {
        super.onStop(board);
        board.dbase.setPower(0,0);
    }
}