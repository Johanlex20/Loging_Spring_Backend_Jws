package Loging.Loging_Spring_Backend_Jws.config;

import Loging.Loging_Spring_Backend_Jws.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// 12 - Agregar las Anotaciones @Configuration 

@Configuration
@RequiredArgsConstructor

public class ApplicationConfig {

// 12.4 - Instanciar la clase Repository
    private final UserRepository userRepository;

// 12.1 - Crear metodo AuthenticationManager intanciar con el metodo AuthenticationConfiguration y retornar con getAuthenticationManager()

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

// 12.2 - Crear metodo AuthenticationProvider con DaoAuthenticationProvider   

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService()); //Se crea metodo userDetailService() a un no esta implementado
        authenticationProvider.setPasswordEncoder(passwordEncoder()); //Se crea metodo passwordEncoder() a un no esta implementado
        return authenticationProvider;
    }

// 12.3 - Implementamos metodos PasswordEndcoder() y UserDetailService()    

    @Bean
    public PasswordEncoder passwordEncoder() { //Importante el metodo tiene que ser publico
        return  new BCryptPasswordEncoder(); // BCryptPasswordEncoder() funcion para encriptar password
    }

    @Bean
    public UserDetailsService userDetailService() { //Importante el metodo tiene que ser publico
        return username -> userRepository.findByUsername(username) // userRepository neceista ser instanciado
                .orElseThrow(()-> new UsernameNotFoundException("User not found")); // lanzar execption si no existe
    }

}
