package org.example.cli.example;

import picocli.CommandLine;

@CommandLine.Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {

    @Override
    public void run() {
        System.out.println("执行主命令。。。");
    }

    @CommandLine.Command(name = "add", description = "增加", mixinStandardHelpOptions = true)
    public static class AddCommand implements Runnable {

        @Override
        public void run() {
            System.out.println("执行 add 命令");
        }
    }

    @CommandLine.Command(name = "delete", description = "删除", mixinStandardHelpOptions = true)
    public static class DeleteCommand implements Runnable {

        @Override
        public void run() {
            System.out.println("执行 delete 命令");
        }
    }

    @CommandLine.Command(name = "query", description = "查询", mixinStandardHelpOptions = true)
    public static class QueryCommand implements Runnable {

        @Override
        public void run() {
            System.out.println("执行 query 命令");
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(args);
        System.exit(exitCode);
    }
}
