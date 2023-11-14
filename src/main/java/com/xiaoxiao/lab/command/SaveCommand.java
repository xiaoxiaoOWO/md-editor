package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;
import com.xiaoxiao.lab.document.Document;

import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements Command {
    @Override
    public void execute() throws IOException {
        Document document = Main.document;
        FileWriter writer = new FileWriter(document.getFile());
        for (String content : document.getContent()) {
            writer.write(content);
            writer.write("\n");
        }
        writer.close();
        Main.commandsContainer.add(this);
    }

    @Override
    public void redo() throws IOException {

    }

    @Override
    public boolean undo() {
        return false;
    }

}
