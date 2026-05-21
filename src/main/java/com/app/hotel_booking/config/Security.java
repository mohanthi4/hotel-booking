package com.app.hotel_booking.config;

import com.app.hotel_booking.filter.JwtFilter;
import com.app.hotel_booking.services.AppUserDetailsService;
import com.app.hotel_booking.filter.LogginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity, LogginFilter logginFilter) {
        httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/api/users/register").permitAll()
                            .requestMatchers("/api/users/login").permitAll()
<<<<<<< HEAD
                            .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin(AbstractHttpConfigurer::disable);

=======
                            .requestMatchers("/api/*").permitAll()
                            .requestMatchers("/api/*/*").permitAll()
                            .requestMatchers("/api/*/*/*").permitAll()
                            .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin.loginProcessingUrl("/login"));
>>>>>>> e2af54455c41903c419f6a89eedb7e941ea0f6cc
        return httpSecurity.build();
    }

    @Bean
    public AppUserDetailsService appUserDetailsService(PasswordEncoder passwordEncoder) {
        ConcurrentHashMap<String, UserDetails> users = new ConcurrentHashMap<>();
        return new AppUserDetailsService(users, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
