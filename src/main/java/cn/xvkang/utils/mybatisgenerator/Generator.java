package cn.xvkang.utils.mybatisgenerator;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
	public static void main(String[] args)
			throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		//File configFile = new File(				"/Volumes/mac-bak/main-workspace/eclipse-workspace/mybatis-generator/generatorConfig-oracle.xml");
		//File configFile = new File("D:/Users/admin/eclipse-workspace/ssm-nyzft/mybatis-generator/generatorConfig-oracle.xml");
		InputStream resourceAsStream = Generator.class.getResourceAsStream("generatorConfig-mysql.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(resourceAsStream);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
}
