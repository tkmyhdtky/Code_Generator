package org.example.cli.command;

import cn.hutool.core.bean.BeanUtil;
import org.example.gererator.MainGenerator;
import org.example.model.MainTemplateConfig;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "generate", mixinStandardHelpOptions = true, description = "生成代码")
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-l", "--list"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;

    @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private String author = "wangZhao";

    @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText = "sum = ";


    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息： " + mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }

}
