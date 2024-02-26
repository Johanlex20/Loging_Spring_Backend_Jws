package Loging.Loging_Spring_Backend_Jws.config;

import Loging.Loging_Spring_Backend_Jws.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// 1- Agregar las Anotaciones Configuration

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity

public class SecurityConfig {

// 13.4 - Instanciamos las variables    
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

// 2- Crear Metodo SecurityFilterChain que es un filtro y agregar la anotacion @Bean

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf->csrf .disable())  /*Desabilitar parametro de suguridad token csrf*/

                .authorizeHttpRequests( authRequest ->
                        authRequest
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                //.formLogin(withDefaults())

// 13.1 -  Inavilitar las secciones          
                .sessionManagement(sessionManagement ->
                    sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// 13.2 - Especificamos la autenticacion Provider
                .authenticationProvider(authProvider)
// 13.3 - Agregamos el Filtro jwtAthenticationFilter
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
