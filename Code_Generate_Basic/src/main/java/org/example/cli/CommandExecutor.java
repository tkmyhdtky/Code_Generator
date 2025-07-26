package org.example.cli;


import org.example.cli.command.ConfigCommand;
import org.example.cli.command.GenerateCommand;
import org.example.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "yuzi", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    // 执行命令
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
