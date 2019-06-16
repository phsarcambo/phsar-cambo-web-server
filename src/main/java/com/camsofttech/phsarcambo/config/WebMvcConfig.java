package com.camsofttech.phsarcambo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author : chhai chivon on 3/28/2019.
 * Software Engineer
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    public WebMvcConfig() {
        System.setProperty("logFilename", "chivon");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET","POST","DELETE","PUT","OPTIONS","PATCH")
                .allowedOrigins("*");
    }

    /*@Bean
    LoggerContext LoggerContextConfig(){
      org.apache.logging.log4j.core.LoggerContext ctx = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
      ctx.reconfigure();
      return ctx;
    }*/
}
