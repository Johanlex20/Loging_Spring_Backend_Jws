package Loging.Loging_Spring_Backend_Jws.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 2- Agregar las ANOTACIONES  

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor

public class AuthController {

// 6.2 Instanciamos un nueva variable que llega del Sevice AuthService

    private final AuthService authService;

// 2.1 - Creamos las funciones

// 6.1 - Modificamos las funciones con ResponseEntity 

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request)); // 6.3 usamos authService
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> Register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request)); // 6.4 usamos authService
    }

}
