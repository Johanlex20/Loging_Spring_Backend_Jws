package Loging.Loging_Spring_Backend_Jws.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LoginRequest {

    String username;
    String password;

}
