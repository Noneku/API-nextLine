package fr.ln.nextLine.config.Security;

import fr.ln.nextLine.config.Security.Filter.JwtRequestFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;
    private final AuthUserDetailsService authUserDetailsService;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter, AuthUserDetailsService authUserDetailsService) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.authUserDetailsService = authUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(c ->c.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                // Définir les autorisations pour les requêtes HTTP
                .authorizeHttpRequests((authorize) -> authorize
                        //Disabled Security
                            //.anyRequest().permitAll()
                        //Disabled Security

                        .requestMatchers("auth/login").permitAll()

                        //Utilisateur
                                .requestMatchers("/user/all-users").hasAnyRole("ADMIN", "FORMATEUR")
                                .requestMatchers("/user/create-user").hasAnyRole("ADMIN", "FORMATEUR")
                                .requestMatchers("/user/update-user/*").hasAnyRole("ADMIN", "FORMATEUR", "STAGIAIRE")
                                .requestMatchers("/user/delete-user/*").hasAnyRole("ADMIN", "FORMATEUR")

                            .anyRequest().authenticated()
                        //Utilisateur
                )

                // Configurer la gestion des sessions

                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Session Stateless est utilisé pour les Tokens JWT (Bearer)
                )
                //Mise en place d'un filtre personnalisé JWT
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean //Gère le processus d'authentification des utilisateurs.
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(authUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authenticationProvider);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
