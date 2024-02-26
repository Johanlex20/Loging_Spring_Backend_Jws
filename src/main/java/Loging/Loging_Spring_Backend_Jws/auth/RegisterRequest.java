package Loging.Loging_Spring_Backend_Jws.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 5 - Agregamos las Anotaciones y Generamos las variables 

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    String username;
    String password;
    String firstname;
    String lastname;
    String country;

}
