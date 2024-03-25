package org.akiratran.hibermusic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This class configures security settings for the application
 */
@Configuration
public class SecurityConfig {
    private CustomUserDetailsService userDetailService;

    /**
     * Construct a new instance of SecurityConfig wit the provided CustomerDetailsService
     * @param userDetailsService {Object} - userDetailsService the custom user details
     * service sued for authentication
     */
    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailService = userDetailsService;
    }

    /**
     * Creates a bean for password encoder
     * @return {Object} - a PasswordEncoder for encoding and decoding passwords
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures security filters and authorization rules
     * @param http {Object} - HttpSecurity object used for configuring security
     * @return {Object} - returns SecurityFilterChain for handling security filters
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/signup/**").permitAll()
                    .requestMatchers("/js/**", "/styles/css/**", "/images/**").permitAll()
                    .requestMatchers("/home").permitAll()
                    .requestMatchers("click/musicInfo").permitAll()
                    .requestMatchers("/about").permitAll()
                    .requestMatchers("/delete").permitAll()
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

