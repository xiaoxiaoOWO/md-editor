package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;
import com.xiaoxiao.lab.Stats;
import com.xiaoxiao.lab.document.Document;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class LoadCommand implements Command {
    String path;

    LoadCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建文件失败");
            }
        }
        List<Stats> statses = Main.statses;
        if (!statses.isEmpty()) {
            Stats stats = statses.get(statses.size() - 1);
            stats.setEndTime(LocalDateTime.now());
            Duration duration = Duration.between(stats.getStartTime(), stats.getEndTime());
            Main.statsFile.logStats(stats.getName() + " " + StatsCommand.getString(duration));
        }


        statses.add(new Stats("./" + path, LocalDateTime.now()));

        Main.document = new Document(file);
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
