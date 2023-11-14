package com.xiaoxiao.lab.document;

public class OrderedList extends Line {
    String text;
    int order;
    OrderedList(String content) {
        super(content);
        order = content.charAt(0) - '0';
        text = content.split(" ",2)[1];
    }

    @Override
    public String getText(){
        return text;
    }

    @Override
    public void print(int prefix) {
        System.out.println(" ".repeat(prefix) + order + ". " + text);
    }
}
