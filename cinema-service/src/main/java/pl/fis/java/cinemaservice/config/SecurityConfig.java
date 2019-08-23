package pl.fis.java.cinemaservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests().anyRequest().permitAll();
        //http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        // ? for postman
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}
