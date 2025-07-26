package org.example.gererator;

import org.example.model.MainTemplateConfig;

public class MainGenerator {

    public static void doGenerate(Object model) throws Exception {
        String inputPath = "D:\\Code\\Code_Generate\\Code_Generate_Basic\\acm-template";
        String outputPath = "D:\\Code\\Code_Generate\\";

        // 静态文件生成
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        // 动态文件生成
        inputPath = "D:\\Code\\Code_Generate\\Code_Generate_Basic\\src\\main\\resources\\templates\\MainTemplate.java.ftl";
        outputPath = "D:\\Code\\Code_Generate\\Code_Generate_Basic\\acm-template\\src\\com\\yupi\\acm\\MainTemplate.java";

        DynamicGenerator.doGenerate(inputPath, outputPath, model);
    }

    public static void main(String[] args) throws Exception {
        MainTemplateConfig  config = new MainTemplateConfig();
        config.setOutputText("求和结果：");
        config.setAuthor("wangzhao");
        config.setLoop(false);
        MainGenerator.doGenerate(config);
    }

}
