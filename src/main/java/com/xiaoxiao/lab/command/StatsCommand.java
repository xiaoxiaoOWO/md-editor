package com.xiaoxiao.lab.command;

import com.xiaoxiao.lab.Main;
import com.xiaoxiao.lab.Stats;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class StatsCommand implements Command {
    String type;

    public StatsCommand(String type) {
        if (type.equals("all") || type.equals("current")) {
            this.type = type;
        } else {
            System.out.println("Invalid type of stats command");
        }
    }

    public StatsCommand() {
        this.type = "current";
    }

    @Override
    public void execute() {
        List<Stats> statses = Main.statses;
        System.out.println("session start at" + " " + statses.get(0).getStartTime());
        if (type.equals("all")) {
            int size = statses.size();
            for (int i = 0; i < size - 1; i++) {
                Stats stats = statses.get(i);
                Duration duration = Duration.between(stats.getStartTime(), stats.getEndTime());
                String formattedDuration = getString(duration);
                System.out.println(stats.getName() + " " + formattedDuration);
            }
        }
        Stats stats = statses.get(statses.size() - 1);
        Duration duration = Duration.between(stats.getStartTime(), LocalDateTime.now());
        String formattedDuration = getString(duration);
        System.out.println(stats.getName() + " " + formattedDuration);
    }

    @Override
    public void redo() throws IOException {

    }

    @Override
    public boolean undo() {

        return false;
    }

    public static String getString(Duration duration) {
        long days = duration.toDays();
        Duration durationMinusDays = duration.minusDays(days);

        long hours = durationMinusDays.toHours();
        Duration durationMinusHours = durationMinusDays.minusHours(hours);

        long minutes = durationMinusHours.toMinutes();
        long seconds = durationMinusHours.minusMinutes(minutes).getSeconds();
        String formattedDuration;
        if (minutes == 0) {
            formattedDuration = String.format("%d秒", seconds);
        } else if (hours == 0) {
            formattedDuration = String.format("%d分%d秒", minutes, seconds);
        } else if (days == 0) {
            formattedDuration = String.format("%d小时%d分%d秒", hours, minutes, seconds);
        } else {
            formattedDuration = String.format("%d天%d小时%d分%d秒", days, hours, minutes, seconds);
        }
        return formattedDuration;
    }


}
