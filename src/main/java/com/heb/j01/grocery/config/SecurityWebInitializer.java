/**
 * 
 */
package com.heb.j01.grocery.config;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

/**
 * Instead of defining the delegating filter proxy in xml, let's do with with a simple class extend.<br/>
 * This class will intercept requests to the app and delegate them to the springSecurityFilterChain bean,
 * which is a FilterChainProxy. The necessary filters are created automatically upon enabling spring security.
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
	private static final Logger LOGGER = LogManager.getLogger(SecurityWebInitializer.class);

}
