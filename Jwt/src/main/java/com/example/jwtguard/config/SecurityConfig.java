package com.example.jwtguard.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // CSRF'yi devre dışı bırakıyoruz
            .authorizeHttpRequests()
            .requestMatchers("/api/auth/register", "/api/auth/login").permitAll() // register ve login'e izin veriyoruz
            .anyRequest().authenticated() // diğer tüm isteklere kimlik doğrulama istiyoruz
            .and()
            .cors(); // CORS yapılandırmasını ekliyoruz
        return http.build();
    }
}