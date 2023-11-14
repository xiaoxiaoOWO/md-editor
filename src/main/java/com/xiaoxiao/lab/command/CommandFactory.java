package com.xiaoxiao.lab.command;

public final class CommandFactory {
    public static Command createCommand(String command) {
        String[] split = command.split(" ", 2);
        if (split.length == 0) {
            return null;
        }
        String cmd = split[0];
        if (split.length == 1) {
            return switch (cmd) {
                case "save" -> new SaveCommand();
                case "undo" -> new UndoCommand();
                case "redo" -> new RedoCommand();
                case "list" -> new ListCommand();
                case "list-tree" -> new ListTreeCommand();
                case "dir-tree" -> new DirTreeCommand();
                case "history" -> new HistoryCommand();
                case "stats" -> new StatsCommand();
                default -> null;
            };
        } else {
            return switch (cmd) {
                case "load" -> new LoadCommand(split[1]);
                case "save" -> new SaveCommand();
                case "insert" -> new InsertCommand(split[1]);
                case "append-head" -> new AppendHeadCommand(split[1]);
                case "append-tail" -> new AppendTailCommand(split[1]);
                case "delete" -> new DeleteCommand(split[1]);
                case "dir-tree" -> new DirTreeCommand(split[1]);
                case "history" -> new HistoryCommand(split[1]);
                case "stats" -> new StatsCommand(split[1]);
                default -> null;
            };
        }
    }
}
