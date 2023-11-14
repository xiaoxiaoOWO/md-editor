package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;

import java.io.IOException;

public class ListTreeCommand implements Command {
    ListTreeCommand(){
        Main.document.reCompose();
    }

    @Override
    public void execute() {
        System.out.print("\n");
        Main.document.getComposite().print(-4);
    }

    @Override
    public void redo() throws IOException {

    }

    @Override
    public boolean undo() {

        return false;
    }


}
