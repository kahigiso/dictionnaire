package net.francais.mashi.config;

import net.francais.mashi.DispatcherConfig;
import net.francais.mashi.dic.controllers.HomeController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.portlet.mvc.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan("net.francais.mashi.dic")
@Import(DispatcherConfig.class)
public class WebConfig {
	
	@Bean(name ="viewResolver")
	public InternalResourceViewResolver getViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setPrefix(".jsp");
		return viewResolver;
	}
	
	@Bean(name="/")
	public Controller getHomeController(){
		return (Controller) new HomeController();
		
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject() );
		return transactionManager;
	}
	

}
