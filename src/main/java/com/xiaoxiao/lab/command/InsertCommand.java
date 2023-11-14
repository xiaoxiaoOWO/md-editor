package com.xiaoxiao.lab.command;


import com.xiaoxiao.lab.Main;

import java.io.IOException;

public class InsertCommand implements Command {
    String content;
    int insertIndex;

    public InsertCommand(String content) {
        this.content = content;
    }


    @Override
    public void execute() throws IOException {
        String[] split = content.split(" ", 2);
        if (split.length == 1) {
            insertIndex = Main.document.getLines().size();
            Main.document.insert(content);
            Main.commandsContainer.add(this);
        } else {
            try {
                insertIndex = Integer.parseInt(split[0]) - 1;
                if (insertIndex > Main.document.getLines().size() - 1) {
                    System.out.println("行数超过当前最大行数，插入失败");
                } else {
                    Main.document.insert(insertIndex, split[1]);
                    Main.commandsContainer.add(this);
                }
            } catch (NumberFormatException e) {
                insertIndex = Main.document.getLines().size();
                Main.document.insert(content);
                Main.commandsContainer.add(this);
            }
        }
    }

    @Override
    public void redo() throws IOException {
        String[] split = content.split(" ", 2);
        if (split.length == 1) {
            insertIndex = Main.document.getLines().size();
            Main.document.insert(content);
        } else {
            try {
                insertIndex = Integer.parseInt(split[0]) - 1;
                if (insertIndex > Main.document.getLines().size() - 1) {
                    System.out.println("行数超过当前最大行数，插入失败");
                } else {
                    Main.document.insert(insertIndex, split[1]);
                }
            } catch (NumberFormatException e) {
                insertIndex = Main.document.getLines().size();
                Main.document.insert(content);
            }
        }
    }

    @Override
    public boolean undo() {
        Main.document.getLines().remove(insertIndex);
        return true;
    }

}