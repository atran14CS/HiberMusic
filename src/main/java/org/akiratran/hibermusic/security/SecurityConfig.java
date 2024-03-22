package org.akiratran.hibermusic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    private CustomUserDetailsService userDetailService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/signup/**").permitAll()
                    .requestMatchers("/home").permitAll()
                    .requestMatchers("click/musicInfo").permitAll()
                    .requestMatchers("/about").permitAll()
                    .requestMatchers("/home").hasRole("USER").anyRequest().authenticated()
//                    .requestMatchers("/profile/createPlaylist")
//                    .requestMatchers("/profile/search").permitAll()
//                    .requestMatchers("/profile/addToPlaylist").permitAll()
                )
                .formLogin(
                form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/profile")
                .failureUrl("/login?error=true")
                .permitAll()
                )
                .logout(
                logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll());
        return http.build();
    }

}

