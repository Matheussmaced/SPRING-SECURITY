package dio.dio_spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests(authorizeRequests -> authorizeRequests
            .anyRequest().authenticated())
        .formLogin(formLogin -> formLogin
            .permitAll())
        .logout(logout -> logout
            .permitAll());
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("user")
        .password("user123")
        .roles("USERS")
        .build();

    UserDetails admin = User.withDefaultPasswordEncoder()
        .username("admin")
        .password("master123")
        .roles("MANAGERS")
        .build();

    return new InMemoryUserDetailsManager(user, admin);
  }
}
