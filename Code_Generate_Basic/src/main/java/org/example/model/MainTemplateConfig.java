package org.example.model;

import lombok.Data;


/**
 * 动态模板配置
 */
@Data
public class MainTemplateConfig {
    // 是否生成循环
    private boolean loop = true;

    // 作者
    private String author = "wangZhao";

    // 输出信息
    private String outputText = "sum = ";
}
