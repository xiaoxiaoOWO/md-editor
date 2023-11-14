package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;
import com.xiaoxiao.lab.document.Line;

import java.io.IOException;
import java.util.List;

public class ListCommand implements Command {
    @Override
    public void execute() {
        System.out.print("\n");
        List<Line> lines = Main.document.getLines();
        for (Line line : lines) {
            System.out.println(line.getContent());
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
