package com.heb.j01.grocery.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import javax.validation.ValidatorFactory;

@Configuration
@EnableWebMvc
@ComponentScan("com.heb.j01.grocery.web")
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(WebConfig.class);

    /**
     * Going to use apache tiles, it simplifies the building blocks of pages.
     *
     * @return tilesConfigurer
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        LOGGER.info("tilesConfigurer hit!");
        TilesConfigurer configurer = new TilesConfigurer();
        // Specify location of tiles.
        configurer.setDefinitions("/WEB-INF/layout/tiles.xml");
        // Enable refresh.
        configurer.setCheckRefresh(true);
        return configurer;
    }

    @Bean
    @Primary
    public ViewResolver tilesViewResolver() {
        LOGGER.info("viewResolver GET hit!");
        // Example of a regular view resolver.
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//		// This would be necessary if we wanted to format locale specific values, such as dates and money.
//		viewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
//		viewResolver.setExposeContextBeansAsAttributes(true);
        // Tiles view resolver.
        ViewResolver viewResolver = new TilesViewResolver();
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        LOGGER.info("configureDefaultServletHandling hit!");
        // Ask dispatcher servlet to forward requests for static resources to
        // the containers default servlet and not handle.
        configurer.enable();
    }

    /**
     * Spring's implementation of the validator bean for the @Valid and other javax.validation beans.
     * <bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean" />
     * Requires an impl of JSR 303, such as hibernate validator like we have done.
     */
    @Bean
    public ValidatorFactory validator() {
        LOGGER.info("validator hit!");
        return new LocalValidatorFactoryBean();
    }

    /**
     * Use this guy to register views that don't really need any preparation. i.e. login or basic views.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
