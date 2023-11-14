package com.xiaoxiao.lab.document;

public class Head extends Line {
    int level;
    String text;

    Head(String content) {
        super(content);
        String[] parts = content.split(" ",2);
        level = parts[0].length();
        text = parts[1];
    }

    @Override
    public String getText(){
        return text;
    }

    public int getLevel() {
        return level;
    }
}
