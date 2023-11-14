package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;

import java.io.IOException;

public class AppendHeadCommand implements Command {
    String content;

    AppendHeadCommand(String content) {
        this.content = content;
    }

    @Override
    public void execute() {
        Main.document.insert(0, content);
        Main.commandsContainer.add(this);
    }

    @Override
    public void redo() throws IOException {
        Main.document.insert(0, content);
    }

    @Override
    public boolean undo() {
        Main.document.delete(0);
        return true;
    }

}
