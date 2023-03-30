package com.java.command;

import com.java.command.command.Command;

/**
 * @author ll
 */
public class RemoteControl {

    Command command;

    Command undoCommand;

    Command[] onCommands;

    Command[] offCommands;

    public RemoteControl() {

    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
