package cn.pluto.postgraduate.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zqq
 * @create 2019-07-29-10:10
 */
public class GeneratorConfig {
    public void generator() throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // 指定 逆向工程配置文件
        File configFile = new File("src/main/resources/mybatis/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        // 建议大家使用带有selecttive

    }

    public static void main(String[] args) throws Exception {
        try {
            GeneratorConfig generatorSqlmap = new GeneratorConfig();
            generatorSqlmap.generator();
            System.out.println("生成结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
