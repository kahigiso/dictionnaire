package net.francais.mashi.config;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("net.francais.mashi.dic.repositories")
public class JPAConfig {
	
	@Autowired 
	private Environment env;   
	@Value("${init-db:false}") 
	private String initDatabase; 
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject() );
		return transactionManager;
	}
	
	@Bean 
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();   
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); 
		vendorAdapter.setGenerateDdl(Boolean.TRUE); vendorAdapter.setShowSql(Boolean.TRUE);   
		factory.setDataSource(dataSource()); factory.setJpaVendorAdapter(vendorAdapter); 
		factory.setPackagesToScan("net.francais.mashi.dic.entities");   
		Properties jpaProperties = new Properties(); 
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto")); 
		factory.setJpaProperties(jpaProperties);   factory.afterPropertiesSet(); 
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver()); 
		return factory;
	}
	
//	@Bean 
//	public HibernateExceptionTranslator hibernateExceptionTranslator() { 
//		return new HibernateExceptionTranslator(); 
//	} 

    /**
     * Database connection settings
     * @return data source object
     */
    @Bean
    DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource(); 
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName")); 
        dataSource.setUrl(env.getProperty("jdbc.url")); 
        dataSource.setUsername(env.getProperty("jdbc.username")); 
        dataSource.setPassword(env.getProperty("jdbc.password")); 
        return dataSource;
    }

}
