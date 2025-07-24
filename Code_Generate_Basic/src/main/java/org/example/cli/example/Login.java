package org.example.cli.example;

import picocli.CommandLine;

import java.util.concurrent.Callable;


public class Login implements Callable<Integer> {

    @CommandLine.Option(names = {"-u", "--user"}, description = "User name", arity = "0..1")
    String user;

    @CommandLine.Option(names = {"-p", "--password"}, description = "user password", interactive = true, arity = "0..1", required = true)
    String password;

    @CommandLine.Option(names = {"-cp", "--checkPassword"}, description = "Check Password", interactive = true, arity = "0..1", required = true)
    String checkPassword;

    @Override
    public Integer call() throws Exception {
        System.out.println("user is " + user);
        System.out.println("password is " + password);
        System.out.println("checkPassword is " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "picocli", "-p", "123", "-cp", "123");
    }
}
