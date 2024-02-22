package Loging.Loging_Spring_Backend_Jws.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor

public class AuthController {

    @PostMapping(value = "login")
    public String login(){
        return "Login from public endpoint!";
    }

    @PostMapping(value = "register")
    public String Register(){
        return "Register from public endpoint!";
    }

}
