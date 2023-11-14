package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;

import java.io.IOException;

public class RedoCommand implements Command{



    @Override
    public void execute() throws IOException {
        CommandsContainer commandsContainer = Main.commandsContainer;
        if(commandsContainer.reDoable()){
            commandsContainer.addIndex();
            commandsContainer.getCommand().redo();
        }else {
            System.out.println("上一个命令不是undo,无法重做");
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
