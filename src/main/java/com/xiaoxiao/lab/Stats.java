package com.xiaoxiao.lab;

import java.time.LocalDateTime;

public class Stats {
    String name;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Stats(String name, LocalDateTime time) {
        this.name = name;
        this.startTime = time;
        this.endTime = time;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
