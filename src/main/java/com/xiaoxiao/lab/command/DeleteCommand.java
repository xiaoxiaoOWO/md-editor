package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;
import com.xiaoxiao.lab.document.Line;
import com.xiaoxiao.lab.document.LineWithNum;

import java.io.IOException;

public class DeleteCommand implements Command {
    String content;
    int deleteLineNum;
    Line deleteLine;

    DeleteCommand(String content) {
        this.content = content;
    }

    @Override
    public void execute() {
        try {
            deleteLineNum = Integer.parseInt(content) - 1;
            if (deleteLineNum > Main.document.getLines().size() - 1) {
                System.out.println("删除行数超过文档行数,删除失败");
            } else {
                deleteLine = Main.document.delete(deleteLineNum);
                Main.commandsContainer.add(this);
            }
        } catch (NumberFormatException e) {
            LineWithNum lineWithNum = Main.document.delete(content);
            if (lineWithNum.line == null) {
                System.out.println("文本不存在，删除失败");
            } else {
                deleteLineNum = lineWithNum.num;
                deleteLine = lineWithNum.line;
                Main.commandsContainer.add(this);
            }
        }
    }

    @Override
    public void redo() throws IOException {
        try {
            deleteLineNum = Integer.parseInt(content) - 1;
            if (deleteLineNum > Main.document.getLines().size() - 1) {
                System.out.println("删除行数超过文档行数,删除失败");
            } else {
                deleteLine = Main.document.delete(deleteLineNum);
            }
        } catch (NumberFormatException e) {
            LineWithNum lineWithNum = Main.document.delete(content);
            if (lineWithNum.line == null) {
                System.out.println("文本不存在，删除失败");
            } else {
                deleteLineNum = lineWithNum.num;
                deleteLine = lineWithNum.line;
            }
        }
    }

    @Override
    public boolean undo() {
        Main.document.getLines().add(deleteLineNum, deleteLine);
        return true;
    }

}
