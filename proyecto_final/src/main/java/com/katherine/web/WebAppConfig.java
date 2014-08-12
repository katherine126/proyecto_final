package com.katherine.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

    
@EnableWebMvc
@Configuration
@ComponentScan("com.katherine.web")
public class WebAppConfig extends WebMvcConfigurerAdapter{
}
