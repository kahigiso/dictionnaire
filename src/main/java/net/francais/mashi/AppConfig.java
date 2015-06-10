package net.francais.mashi;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.francais.mashi.dic.controllers.HomeController;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.portlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springsource.tcserver.serviceability.request.DataSource;


@Configuration
//@EnableTransactionManagement
@ComponentScan("net.francais.mashi.dic")
@Import(DispatcherConfig.class)
public class AppConfig {

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
		

	   
		
}
