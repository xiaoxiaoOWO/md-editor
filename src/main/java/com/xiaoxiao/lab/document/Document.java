package com.xiaoxiao.lab.document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Document {
    File file;
    List<Line> lines = new ArrayList<>();
    Composite composite;


    public Document(File file) throws IOException {
        this.file = file;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String lineContent;
        while ((lineContent = reader.readLine()) != null) {
            Line line = Line.createLine(lineContent);
            lines.add(line);
        }

        reader.close();
        composite = new Composite();
        composite.composeCompositeFromLines(lines, 0);

    }

    public void reCompose(){
        composite = new Composite();
        composite.composeCompositeFromLines(lines, 0);

    }

    public File getFile() {
        return file;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Composite getComposite() {
        return composite;
    }

    public List<String> getContent() {
        List<String> content = new ArrayList<>();
        for (Line line : lines) {
            content.add(line.getContent());
        }
        return content;
    }

    public void insert(int lineNum, String content) {
        Line line = Line.createLine(content);
        lines.add(lineNum, line);
    }

    public void insert(String content) {
        Line line = Line.createLine(content);
        lines.add(line);
    }

    public Line delete(int lineNum) {
        Line deleteLine = lines.get(lineNum);
        lines.remove(lineNum);
        return deleteLine;
    }

    public LineWithNum delete(String text) {
        LineWithNum lineWithNum = new LineWithNum();
        for (Line line : lines) {
            if (line.getText().equals(text)) {
                lineWithNum.line = line;
                lineWithNum.num = lines.indexOf(line);
                lines.remove(line);
                break;
            }
        }
        return lineWithNum;
    }


    public void delete() {
        Line deleteLine = lines.get(lines.size() - 1);
        lines.remove(lines.size() - 1);
    }




}