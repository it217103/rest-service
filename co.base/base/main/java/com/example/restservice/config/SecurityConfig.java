package base.main.java.com.example.restservice.config;


import base.main.java.com.example.restservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private StudentService studentService;
    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    //security configuration(Using HttpSecurity)
    //authorization of role

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("classpath:/static/**",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/student").access("hasAuthority('ROLE_USER')")
                .antMatchers("/listapplications").access("hasAuthority('ROLE_ADMIN')")
                .antMatchers("/edit/**").access("hasAuthority('ROLE_ADMIN')")
                .antMatchers("/addstudent").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
    @Override
    public void configure(WebSecurity webSecurity)throws Exception{
        webSecurity.ignoring().antMatchers("/resources/**");
        webSecurity.ignoring().antMatchers("/");
    }
//password encoder
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource((DataSource) getStudentService()).passwordEncoder(passwordEncoder()).usersByUsernameQuery("Select username,password, enabled from user username=?").authoritiesByUsernameQuery("select username, authority from authorities where username=?");
    }
}
