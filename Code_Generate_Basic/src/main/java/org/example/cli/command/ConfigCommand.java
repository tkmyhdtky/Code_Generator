package org.example.cli.command;


import cn.hutool.core.util.ReflectUtil;
import org.example.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;


@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("查看参数信息");
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称： " + field.getName());
            System.out.println("字段类型： " + field.getType());
            System.out.println("----------");
        }
    }

}
