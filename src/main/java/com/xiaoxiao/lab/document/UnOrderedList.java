package com.xiaoxiao.lab.document;

public class UnOrderedList extends Line {
    String text;
    UnOrderedList(String content) {
        super(content);
        text = content.split(" ",2)[1];
    }

    @Override
    public String getText(){
        return text;
    }

    @Override
    public void print(int prefix) {
        System.out.println(" ".repeat(prefix) + "." + text);
    }
}
