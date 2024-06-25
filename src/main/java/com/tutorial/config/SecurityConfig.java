package com.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  /**
   * 設定規則
   * @param http HttpSecurity
   * @return SecurityFilterChain
   * @throws Exception exception
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(registry ->
        registry.requestMatchers(HttpMethod.POST, "/account").permitAll()         //POST, 可新增帳號
            .requestMatchers(HttpMethod.GET, "/account/?*").permitAll()           //GET, 可查詢單一帳號
            .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()           //GET, 可查詢單一帳號
            .anyRequest().authenticated()                                         //其它全數拒絕
    ).csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }

  /**
   * 加密採用 spring 本身的 BCryptPasswordEncoder
   * @return PasswordEncoder
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
