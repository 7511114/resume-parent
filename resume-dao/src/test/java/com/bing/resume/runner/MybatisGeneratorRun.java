package com.bing.resume.runner;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * description: 
 * @author chenbing
 */
public class MybatisGeneratorRun {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));

        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
        myBatisGenerator.generate(null);
//        myBatisGenerator.generate(shellCallback);
        for (String string : warnings) {
            System.out.println(string);
        }
        
     /*   com.uenpay.generator.config.xml.ConfigurationParser configurationParser = new com.uenpay.generator.config.xml.ConfigurationParser();
		com.uenpay.generator.config.Configuration configuration = configurationParser.parseConfiguration(MybatisGeneratorRun.class.
				getClassLoader().getResourceAsStream("generatorConfig11.xml"));
		VelocityGenerator velocityGenerator = new VelocityGenerator();
		velocityGenerator.init(configuration);*/
    }

}
