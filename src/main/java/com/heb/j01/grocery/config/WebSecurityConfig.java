package com.heb.j01.grocery.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Spring will generate a default login form for us, easy to create though.<br/>
 * Spring recommends making sure your app works fine with csrf DISABLED before
 * doing much, so as to enable rapid prototyping.
 *
 * @author codeup
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LogManager.getLogger(WebSecurityConfig.class);
    private static final String USERS_QUERY = "select email, password, enabled from users where email = ?";
    private static final String AUTH_QUERY = "select email, role from user_roles where email = ?";
    @Autowired
    DataSource groceryDataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("Configuring http security.");

        // Define login page root and permit all access requests, add success
        // handler.
        http.formLogin().loginPage("/login").permitAll()
                // Define context roots which require security and the
                // corresponding role, and permit all with that role.
                .and().authorizeRequests().antMatchers("/**").hasRole("USER")
                .anyRequest().permitAll()
                // Configure remember me functionality,
                .and().rememberMe().tokenValiditySeconds(2419200).key("groceryKey")
                // Define where to send the user upon logout success.
                .and().logout().permitAll().logoutSuccessUrl("/");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Lots of noise from filters operating on resources. Let's ignore them.
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("Configuring authentication.");
        auth.jdbcAuthentication().dataSource(groceryDataSource).usersByUsernameQuery(USERS_QUERY).passwordEncoder(NoOpPasswordEncoder.getInstance())
                .authoritiesByUsernameQuery(AUTH_QUERY);
    }


}

