package com.bloomtech.bloomtech;

import com.bloomtech.bloomtech.security.JWTAuthorizationFilter;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
public class BloomtechApplication {

	public static void main(String[] args) {

		SpringApplication.run(BloomtechApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@EnableWebSecurity
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.cors().and()
					.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/user/login").permitAll()
					.antMatchers(HttpMethod.POST, "/user/register").permitAll()
					.antMatchers(HttpMethod.POST, "/user/save").permitAll()
					.antMatchers(HttpMethod.PUT, "/user/refer/**").permitAll()

          //.antMatchers(HttpMethod.GET, "/price/find").access("hasAuthority('ROLE_administrador')")
					//.antMatchers("/price/**").permitAll()
					//.antMatchers("/red/level/**").permitAll()

					.antMatchers(HttpMethod.GET,"/user/find").access("hasAuthority('ROLE_administrador')")
					.antMatchers(HttpMethod.PUT,"/user/update/**").access("hasAuthority('ROLE_administrador')")
					.antMatchers(HttpMethod.DELETE,"/user/delete/**").access("hasAuthority('ROLE_administrador')")
					.antMatchers(HttpMethod.GET, "/red/level/**").access("hasAuthority('ROLE_administrador') or hasAuthority('ROLE_usuario')")
                    //.antMatchers(HttpMethod.GET, "/red/level/**").access("hasAuthority('ROLE_usuario')")

					.anyRequest().authenticated();
		}
		@Bean
		CorsConfigurationSource corsConfigurationSource(){
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
            configuration.setAllowedMethods(Arrays.asList("GET","POST","OPTIONS","PUT","PATCH","DELETE"));
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
		}
	}
}
