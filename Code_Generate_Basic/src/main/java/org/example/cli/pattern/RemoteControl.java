package org.example.cli.pattern;

import lombok.Data;

@Data
public class RemoteControl {
    private Command command;

    public void pressButton() {
        command.execute();
    }
}
