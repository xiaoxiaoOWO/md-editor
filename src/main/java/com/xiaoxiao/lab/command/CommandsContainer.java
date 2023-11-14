package com.xiaoxiao.lab.command;

import java.util.*;

public class CommandsContainer {
    private final List<Command> commands;
    private int index;

    public CommandsContainer(){
        index = -1;
        commands = new ArrayList<>();
    }

    public void add(Command command){
        commands.add(command);
        index = commands.size()-1;
    }

    public boolean reDoable(){
        return index < commands.size()-1;
    }

    public void addIndex(){
        index++;
    }

    public void subIndex(){
        index--;
    }

    public Command getCommand(){
        return commands.get(index);
    }
}
