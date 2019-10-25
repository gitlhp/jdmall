package com.lhp.demo.autombg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Generator
 * @Description: auto启动类
 * @Author: 李怀鹏
 * @Company: bjut
 * @Date： 2019/10/24 10:45
 * @Version： V1.0
 **/
public class Generator {
    public static void main(String[] args) throws Exception {
        //mbg执行中的告警信息
        List<String> warning = new ArrayList<>();
        //当代码重复时，覆盖之前代码
        boolean overwrite =true;
        //读取配置文件呢、
        InputStream input= Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser configurationParser =new ConfigurationParser(warning);
        Configuration config = configurationParser.parseConfiguration(input);
        input.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建 MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warning);
        //执行生成代码
        myBatisGenerator.generate(null);
        //输出警告信息
        for (String data : warning) {
            System.out.println(data);
        }
    }
}
