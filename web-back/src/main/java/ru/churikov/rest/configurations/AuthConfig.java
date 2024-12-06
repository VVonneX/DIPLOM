package ru.churikov.rest.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    private UserDetailsService UserDetailsService;
    //Сервис, который отвечает за информацию о пользователе

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //Штуки для хеширования паролей в бд, для обеспечения безопасности(чтобы не украли)

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(UserDetailsService);
    }

    // интегрирует UserDetailsService в механизм ауинтификации spring
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        System.setProperty("https.protocols", "TLSv1.2");
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);
        http
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers("/hello").authenticated()
                .antMatchers("/auth/*").permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/auth/login")
                .and()
                .logout()
                .logoutUrl("/auth/logout") // все, что представленно выше, доступных апишек(по сути, настраиваю уровни доступа для пользователей)
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        if (authentication != null && authentication.getDetails() != null) {
                            try {
                                request.getSession().invalidate();
                            } catch (Exception e) {
                                e.printStackTrace();
                                e = null;
                            }
                        }
                        response.setStatus(HttpServletResponse.SC_OK);
                    }
                }) // она определяет последоватеельноть действий вы успешном выходе пользователя с учетной записи
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(false)
                .permitAll()
                .and()
                .exceptionHandling()
                .and()
                .csrf().disable();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
    // настройка позволяющая принмать запросы с внешних источников(по сути, общение, условно, между серверами)
}
