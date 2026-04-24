package org.firstinspires.ftc.teamcode.autoCommander;

import org.firstinspires.ftc.teamcode.boardmeeting.ProgramBoard;

import java.util.ArrayList;

public class AutoCommander {
    public ProgramBoard board;
    public ArrayList<BotCommand> commandQueue;
    public AutoCommander(ProgramBoard board) {
        // Sets this class's "board" variable to the initializer's "board" input.
        this.board = board;
    }

    public BotCommand addCommand(BotCommand command){
        // Adds a command to the commandQueue list.
        return commandQueue.add(command) ? command : new BotCommand(this.board, 0);
    }
    public void addCommandAndRun(BotCommand command){
        // Adds a command to the commandQueue list...
        if (commandQueue.add(command)) {
            // ...and then runs it.
            runLatestCommand();
        }
    }
    public void runOldestQueuedCommand(){
        /* Queries the first command in the queue (or a new BotCommand)
        * using its stream, which is essentially a sequence of elements
        * that one can do operations on. In this case, I'm (our main
        * programmer is) using it to find the first element in the stream.
        * This element is then assigned to commandToRun.
        */
        if (!commandQueue.isEmpty()) {
            BotCommand commandToRun = commandQueue
                    .stream().findFirst()
                    .orElse(new BotCommand(this.board, 0));
            // Executes the command...
            commandToRun.execute(this.board);
            // ...and then removes said command from the queue.
            commandQueue.remove(commandToRun);
        }
    }
    public void runLatestCommand(){
        // Queries the last command in the queue and assigns it to commandToRun.
        if (!commandQueue.isEmpty()) {
            BotCommand commandToRun = commandQueue
                    .get(commandQueue.size() - 1);
            // Executes the command...
            commandToRun.execute(this.board);
            // ...and then removes said command from the queue.
            commandQueue.remove(commandToRun);
        }
    }
    public void runAllQueuedCommands(){
        // While the command queue still has items in it...
        while (!commandQueue.isEmpty()) {
            // ...run the oldest queued command.
            runOldestQueuedCommand();
        }
    }
}