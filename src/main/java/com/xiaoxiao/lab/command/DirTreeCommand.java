package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;

import java.io.IOException;

public class DirTreeCommand implements Command {

    String column;

    DirTreeCommand(){
        column = null;
        Main.document.reCompose();
    }

    DirTreeCommand(String column){
        Main.document.reCompose();
        this.column = column;
    }

    @Override
    public void execute() {
        System.out.print("\n");
        if (column == null){
            Main.document.getComposite().print(-4);
        }else {
            Main.document.getComposite().checkAndPrint(column);
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
