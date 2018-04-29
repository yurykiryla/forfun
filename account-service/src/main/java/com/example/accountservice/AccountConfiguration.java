package com.example.accountservice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
@ComponentScan
@EntityScan("com.example.accountservice")
@EnableJpaRepositories("com.example.accountservice")
@PropertySource("classpath:db-config.properties")
public class AccountConfiguration {
	
	private Logger logger;

	public AccountConfiguration() {
		super();
		logger = Logger.getLogger(getClass().getName());
	}
	
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");
		
		DataSource dataSource = new EmbeddedDatabaseBuilder()
				.addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql")
				.build();
		
		logger.info("datasourc = " + dataSource);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> accounts = jdbcTemplate.queryForList("SELECT number from T_ACCOUNT");
		logger.info("system has " + accounts.size() + " accounts");
		
		Random random = new Random();
		
		accounts.forEach(item -> {
			String number = (String) item.get("number");
			BigDecimal balance = new BigDecimal(random.nextInt(10000000) / 100.0)
					.setScale(2, RoundingMode.HALF_EVEN);
			jdbcTemplate.update("UPDATE T_ACCOUNT SET balance = ? WHERE number = ?", balance, number);
		});
		
		return dataSource;
	}
}
