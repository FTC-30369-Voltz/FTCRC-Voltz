package org.firstinspires.ftc.teamcode.autoCommander;

import java.lang.Thread;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

public class BotCommand {
    public ProgramBoard board;
    public double time;
    public BotCommand(ProgramBoard board, double sleepTime) {
        this.board = board;
        this.time = sleepTime;
    }
    public void execute(ProgramBoard board) {
        onInit(board);
        try {
            if (this.time > 0) {
                Thread.sleep((int)this.time* 1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        onStop(board);
    }
    public void onInit(ProgramBoard board) {}
    public void onStop(ProgramBoard board) {}
}