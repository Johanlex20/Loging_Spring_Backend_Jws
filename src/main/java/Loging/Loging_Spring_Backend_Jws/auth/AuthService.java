package Loging.Loging_Spring_Backend_Jws.auth;

import Loging.Loging_Spring_Backend_Jws.jwt.JwtService;
import Loging.Loging_Spring_Backend_Jws.user.Role;
import Loging.Loging_Spring_Backend_Jws.user.User;
import Loging.Loging_Spring_Backend_Jws.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user)) //pendiente crear la variable del token
                .build();
    }
}
