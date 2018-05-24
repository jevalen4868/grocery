package com.heb.j01.grocery.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
// Scans all packages by default, except the controllers that are already scanned by the WebConfig class, which is annotated with @EnableWebMvc.
@ComponentScan(basePackages = { "com.heb.j01.grocery.config" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
// Ensure that we import other necessary configs here.
public class RootConfig {

}
