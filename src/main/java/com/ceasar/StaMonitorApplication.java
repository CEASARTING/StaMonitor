package com.ceasar;


import com.ceasar.domian.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jcouchdb.db.Database;
import org.jcouchdb.db.ServerImpl;
import org.jcouchdb.document.BaseDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.jcouchdb.db.Server;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class StaMonitorApplication {

	// 使用log4j2打印日志
	private static final Logger m_logger = LogManager.getLogger(StaMonitorApplication.class);

	// 在子线程中依赖注入dao的时候使用
	public static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(StaMonitorApplication.class, args);

		m_logger.info("|======================================================|");
		m_logger.info("|======================================================|");
		m_logger.info("|---------------(SpringBoot Start Success)-------------|");
		m_logger.info("|======================================================|");
		m_logger.info("|======================================================|");
	}


	@Bean
	public BaseDocument getDocument(){
		//todo
		//Server server = new ServerImpl("192.168.1.100",5964);
		Database database = new Database("localhost","dp");
		BaseDocument baseDocument = database.getDocument(BaseDocument.class,"4667488c25f99c2a2fadd900b600325c");
		return baseDocument;
	}
	@Bean
	public Database getDatabase(){
		//todo
		//Server server = new ServerImpl("192.168.1.100",5964);
		Database database = new Database("localhost","dp");
		//BaseDocument baseDocument = database.getDocument(BaseDocument.class,"4667488c25f99c2a2fadd900b60003f9");
		return database;
	}

}
