package com.xiaoxiao.lab.document;

public class Line implements Component {
    String content;


    Line(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getText() {
        return content;
    }


    @Override
    public void print(int prefix) {
        System.out.println(" ".repeat(prefix)+"--" + getText());
    }




    public static Line createLine(String content) {
        String[] strings = content.split(" ", 2);
        if (strings.length == 1) {
            return new Text(content);
        }

        char firstChar = content.charAt(0);

        if (Character.isDigit(firstChar)) {
            return new OrderedList(content);
        }

        return switch (firstChar) {
            case '#' -> new Head(content);
            case '-', '+', '*' -> new UnOrderedList(content);
            default -> new Text(content);
        };

    }

}
