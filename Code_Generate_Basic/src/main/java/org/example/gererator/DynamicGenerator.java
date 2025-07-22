package org.example.gererator;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.example.model.MainTemplateConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {
    public static void main(String[] args) throws Exception {


        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("王钊");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果: ");
        String inputPath = "D:\\Code\\Code_Generate\\Code_Generate_Basic\\src\\main\\resources\\templates\\MainTemplate.java.ftl";
        String outputPath = "D:\\Code\\Code_Generate\\MainTemplate.java";
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    /**
     * 生成文件
     *
     * @param inputPath  模板文件输入路径
     * @param outputPath 输出路径
     * @param model      数据模型
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws Exception {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);

        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);
        configuration.setDefaultEncoding("UTF-8");

        String templateFile = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateFile);

        Writer out = new FileWriter(outputPath);
        template.process(model, out);
        out.close();
    }
}
