package Loging.Loging_Spring_Backend_Jws.auth;

import Loging.Loging_Spring_Backend_Jws.jwt.JwtService;
import Loging.Loging_Spring_Backend_Jws.user.Role;
import Loging.Loging_Spring_Backend_Jws.user.User;
import Loging.Loging_Spring_Backend_Jws.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// 7 - Agregar las antociones @Service
@Service
@RequiredArgsConstructor

public class AuthService {

// 8.2 Instanciamos Repository

    private final UserRepository userRepository;

// 8.5 Instanciamos JwtServices   

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

// 15.2 - Instanciar AutenticationManager    
    private final AuthenticationManager authenticationManager;

// 7.1 - Agregando Metodo Login y Register con AuthResponse
// 15.1 - Implementar Metodo Login

    public AuthResponse login(LoginRequest request) {
// 15.3 - Instancimaos authenticationManager        
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
// 15.4 - Generar Token usar UserDetails      
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

// 8 - Implementar Metodo Register    

    public AuthResponse register(RegisterRequest request) {

// 8.1 Instanciamos user de la clase User

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.lastname)
                .country(request.getCountry())
                .role(Role.USER)
                .build();

// 8.3 -  Guardamos mediante UserRepository

        userRepository.save(user);

// 8.4 - retornar objeto del tipo AuthResponse

        return AuthResponse.builder()
// 8.6  Invocamos el metodo getToken     
                .token(jwtService.getToken(user))
                .build();

    }
}
