package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;

import java.io.IOException;

public class UndoCommand implements Command{


    @Override
    public void execute() {
        CommandsContainer commandsContainer = Main.commandsContainer;
        if(commandsContainer.getCommand().undo()){
            commandsContainer.subIndex();
        }
    }

    @Override
    public void redo() throws IOException {

    }

    @Override
    public boolean undo() {

        return false;
    }


}
