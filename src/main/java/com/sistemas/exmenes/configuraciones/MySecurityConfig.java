
package com.sistemas.exmenes.configuraciones;

import com.sistemas.exmenes.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity //Nos permite especificar la configuracion de acceso a los recursos publicados
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //Se declara "true" para que este habilitado
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private JwtAutheticationEntryPoint unauthorizeHandler;
    
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); 
    }
    
    @Bean //Encriptamos las contraseñas de los usuarios
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    //Password encriptado
  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }
    
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http
                /*.csrf()
                .disable() //Desabilitamos el CSRF
                .cors()
                .disable()
                .and()
                //.authorizeRequests()
                .antMatchers("//swagger-ui/**","/generate-token","/usuarios/").permitAll(); //Permitir a cualquiera
                //.antMatchers("//swagger-ui/**","/generate-token","/usuarios/").permitAll(); //Permitir a cualquiera
                //.antMatchers(HttpMethod.OPTIONS).permitAll() //Describe opcones de comunicacion
                //.anyRequest().authenticated() //Cualquier otra peticion que se solicita la va a untenticar mediante el token
                //.and()
                //.exceptionHandling().authenticationEntryPoint(unauthorizeHandler) 
                //.and()
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);*/
                
                http.cors().and().csrf().disable()
                .authorizeRequests().antMatchers("/api/auth/*", "/api/", "/swagger-ui/*", "/techgeeknext-openapi/", "/v3/api-docs/*").permitAll()             
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
    }
    
    
    
    
}
