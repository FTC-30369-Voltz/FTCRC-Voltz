package org.firstinspires.ftc.teamcode.autoCommander;

import java.lang.Thread;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

public class BotCommand {
    public ProgramBoard board;
    public float time;
    public BotCommand(ProgramBoard board, float sleepTime) {
        this.board = board;
        this.time = sleepTime;
    }
    public void execute(ProgramBoard board) {
        onInit(board);
        try {
            Thread.sleep((int)this.time* 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        onStop(board);
    }
    public void onInit(ProgramBoard board) {}
    public void onStop(ProgramBoard board) {}
}