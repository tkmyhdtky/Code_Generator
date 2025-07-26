package org.example.cli.command;


import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

@Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Override
    public void run() {
        String inputPath = "D:\\Code\\Code_Generate\\Code_Generate_Basic\\acm-template";
        List<File> files = FileUtil.loopFiles(inputPath);
        files.forEach(System.out::println);
    }

}
