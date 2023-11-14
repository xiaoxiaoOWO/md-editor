package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;

import java.io.IOException;

public class AppendTailCommand implements Command {
    String content;
    AppendTailCommand(String content) {
        this.content = content;
    }

    @Override
    public void execute() {
        Main.document.insert(content);
        Main.commandsContainer.add(this);
    }

    @Override
    public void redo() throws IOException {
        Main.document.insert(content);
    }

    @Override
    public boolean undo() {
        Main.document.delete();
        return true;
    }

}
