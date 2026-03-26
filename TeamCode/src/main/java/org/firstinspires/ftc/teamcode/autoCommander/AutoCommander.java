package org.firstinspires.ftc.teamcode.autoCommander;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

import java.util.List;

public class AutoCommander {
    public ProgramBoard board;
    public List<BotCommand> commandQueue;
    public AutoCommander(ProgramBoard board){
        this.board = board;
    }

    public BotCommand addCommand(BotCommand command){
        commandQueue.add(command);
        return command;
    }
    public void addCommandAndRun(BotCommand command){
        commandQueue.add(command);
        runLatestCommand();
    }
    public void runOldestQueuedCommand(){
        BotCommand commandToRun = commandQueue
                .stream().findFirst()
                .orElse(new BotCommand());
        commandToRun.execute(this.board);
        commandQueue.remove(commandToRun);
    }
    public void runLatestCommand(){
        BotCommand commandToRun = commandQueue
                .get(commandQueue.size()-1);
        commandToRun.execute(this.board);
        commandQueue.remove(commandToRun);
    }
    public void runAllQueuedCommands(){
        while (!commandQueue.isEmpty()) {
            runOldestQueuedCommand();
        }
    }
}
