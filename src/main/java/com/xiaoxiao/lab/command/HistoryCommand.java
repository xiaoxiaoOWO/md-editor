package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;

import java.io.IOException;

public class HistoryCommand implements Command {
    int maxNum = 0;

    HistoryCommand() {
    }

    HistoryCommand(String maxNum) {
        try {
            this.maxNum = Integer.parseInt(maxNum);
        } catch (NumberFormatException e) {
            System.out.println("执行失败，参数错误");
        }
    }

    @Override
    public void execute() throws IOException {
        if (maxNum == 0) {
            for (String log : Main.logFile.getLog()) {
                System.out.println(log);
            }
        } else {
            for (String log : Main.logFile.getLog(maxNum)) {
                System.out.println(log);
            }
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
