package com.mac.bry.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {

	@Autowired
	private HibernateJpaVendorAdapter adapter;
	@Autowired
	private DataSource basicDataSource;

	@Bean
	public LocalContainerEntityManagerFactoryBean LCEMF() {
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		containerEntityManagerFactoryBean.setPersistenceUnitName("spring-jpa-pu");
		containerEntityManagerFactoryBean.setJpaVendorAdapter(adapter);
		containerEntityManagerFactoryBean.setDataSource(basicDataSource);
		containerEntityManagerFactoryBean.setPackagesToScan("com.mac.bry.model");
		return containerEntityManagerFactoryBean;
	}
	
	@Bean
	public HibernateJpaVendorAdapter createAdapter () {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		return adapter;
	}
	
	@Bean
	public DataSource createBasicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC");
		basicDataSource.setUsername("MacBry");
		basicDataSource.setPassword("MacBry");
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setInitialSize(5);
		return basicDataSource;
	}
}
