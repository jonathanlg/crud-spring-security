package com.jonathan.CrudSecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jonathan.CrudSecurity.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("usuarioDetailService")
	private UserDetailService userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{	
		http.csrf().disable().authorizeRequests()
        .antMatchers(SecurityConstants.SIGN_UP_URL,"/" ).permitAll() //permitimos el acceso a /login a cualquiera
        .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
        .and()
        // Las peticiones /login pasaran previamente por este filtro
        .addFilterBefore(new LoginFilter(SecurityConstants.SIGN_UP_URL, authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)

        // Las demás peticiones pasarán por este filtro para validar el token
        .addFilterBefore(new JwtFilter(),
                UsernamePasswordAuthenticationFilter.class);
	}

}
