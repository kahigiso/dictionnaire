package net.francais.mashi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;


@Configuration
@EnableWebMvc
@ComponentScan("net.francais.mashi.dic.controllers")
public class DispatcherConfig extends WebMvcConfigurerAdapter{
	
	/**
     * Stores registrations of resource handlers
     * for serving static resources
     * @param registry resource handler registry object
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    /**
     * Allowes direct resolution of symbolic view names to URLs,
     * without explicit mapping definition;
     * it uses apache tiles as a view class
     * @return view resolver object
     */
    @Bean
    UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }
    
    /**
     * Defines tiles configuration files
     * @return tiles configurer object
     */
    @Bean
    TilesConfigurer tilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        String[] definitions = new String[] {
            "/WEB-INF/base/general.xml",
            "/WEB-INF/base/admin.xml",
        };
        configurer.setDefinitions(definitions);
        return configurer;
    }
    
}
