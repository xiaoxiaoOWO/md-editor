package com.xiaoxiao.lab;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.min;

public class LogFile {
    File file;
    FileWriter fileWriter;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

    public LogFile(String path) throws IOException {
        this.file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建文件失败");
            }
        }
        fileWriter = new FileWriter(file, true);
        fileWriter.write("session start at" + " " + LocalDateTime.now().format(DATE_TIME_FORMATTER) + "\n");
        fileWriter.flush();
    }


    public void log(String content) {
        // 获取当前日期时间并格式化
        String timestamp = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        content = timestamp + " " + content + "\n";
        try {
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("写入日志失败");
        }
    }

    public void logStats(String content) {
        try {
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("写入日志失败");
        }
    }


    public List<String> getLog() throws IOException {
        List<String> logs = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String log;
        while ((log = reader.readLine()) != null) {
            if (log.startsWith("s")) {
                continue;
            }
            logs.add(log);
        }
        reader.close();
        Collections.reverse(logs);
        return logs;
    }

    public List<String> getLog(int maxNum) throws IOException {
        List<String> logs = getLog();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < min(maxNum, logs.size()); i++) {
            result.add(logs.get(i));
        }
        return result;
    }
}

