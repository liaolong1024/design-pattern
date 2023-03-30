package com.java.command.command;

/**
 * @author LiaoLong
 * @create 2023-03-30 23:05
 */
public interface Command {
    public void execute();

    void undo();
}
