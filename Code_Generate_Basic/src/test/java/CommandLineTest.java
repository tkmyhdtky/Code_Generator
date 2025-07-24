import org.example.cli.example.SubCommandExample;
import org.junit.Test;
import picocli.CommandLine;

public class CommandLineTest {


    CommandLine commandLine = new CommandLine(new SubCommandExample())
            .addSubcommand(new SubCommandExample.AddCommand())
            .addSubcommand(new SubCommandExample.DeleteCommand())
            .addSubcommand(new SubCommandExample.QueryCommand());

    @Test
    public void testMainCommand() {
        String[] args = {};
        int exitCode = commandLine.execute(args);
        assert exitCode == 0;
    }

    @Test
    public void testCommand_help() {
        String[] args = new String[]{"--help"};
        int exitCode = commandLine.execute(args);
        assert exitCode == 0;
    }

    @Test
    public void testCommand_add() {
        String[] args = new String[]{"add"};
        int exitCode = commandLine.execute(args);
        assert exitCode == 0;
    }

}


