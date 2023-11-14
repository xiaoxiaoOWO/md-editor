package com.xiaoxiao.lab;


import com.xiaoxiao.lab.command.Command;
import com.xiaoxiao.lab.command.CommandFactory;
import com.xiaoxiao.lab.command.CommandsContainer;
import com.xiaoxiao.lab.command.StatsCommand;
import com.xiaoxiao.lab.document.Document;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Document document;

    public static LogFile logFile;

    public static LogFile statsFile;

    public static List<Stats> statses = new ArrayList<>();

    public static CommandsContainer commandsContainer = new CommandsContainer();


    static {
        try {
            logFile = new LogFile("session.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            statsFile = new LogFile("stats.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) throws IOException {
        System.out.println("Program start");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine();
            if (string.equals("exit")) {
                Stats stats = statses.get(statses.size() - 1);
                stats.setEndTime(LocalDateTime.now());
                Duration duration = Duration.between(stats.getStartTime(), stats.getEndTime());
                Main.statsFile.logStats(stats.getName() + " " + StatsCommand.getString(duration));
                break;
            }
            Command command = CommandFactory.createCommand(string);
            if (command == null) {
                System.out.println("Invalid command");
                continue;
            }
            command.execute();
            Main.logFile.log(string);
        }
        scanner.close();

    }
}