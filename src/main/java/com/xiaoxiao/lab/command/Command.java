package com.xiaoxiao.lab.command;

import java.io.IOException;

public interface Command {


    void execute() throws IOException;

    void redo() throws IOException;

    boolean undo();




}