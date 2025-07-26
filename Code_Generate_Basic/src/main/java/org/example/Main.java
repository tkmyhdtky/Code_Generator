package org.example;

import org.example.cli.CommandExecutor;

public class Main {

    public static void main(String[] args) {

//        args = new String[] { "--help" };
//        args = new String[]{"generate", "-l", "-a", "-o"};
        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }

}
