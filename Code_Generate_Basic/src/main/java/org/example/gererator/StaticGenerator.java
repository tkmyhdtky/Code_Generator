package org.example.gererator;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class StaticGenerator {
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    // 递归方式实现文件复制
    public static void copyFile(String src, String dest) throws IOException {
        File inputFile = new File(src);
        // 递归到，终止递归，复制到目标目录下
        if (inputFile.isFile()) {
            Files.copy(inputFile.getAbsoluteFile().toPath(), Paths.get(dest + "/" + inputFile.getName()));
            return;
        }
        // 在目标位置下创建同级目录
        File newDic = new File(dest + "/" + src.substring(src.lastIndexOf("\\") + 1));
        if (!newDic.exists()) newDic.mkdirs();
        File[] files = inputFile.listFiles();
        for (File file : files) {
            copyFile(file.getPath(), newDic.getAbsolutePath());
        }

    }


    public static void main(String[] args) throws IOException {
        // 获取整个项目的根目录
        String path = System.getProperty("user.dir");
        System.out.printf(path);

        String inputPath = new File(path, "Generate_Demo_Project/acm-template").getAbsolutePath();
        String outputPath = path + "/Code_Generate_Basic";
        copyFile(inputPath, outputPath);
    }
}
