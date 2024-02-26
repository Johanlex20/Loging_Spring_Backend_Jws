package Loging.Loging_Spring_Backend_Jws.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1- Agregar las Anotaciones

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor

// 2- Creamos Metodo Protegido

public class DemoController {
    @PostMapping(value = "demo")
    public String welcome(){
        return "welcome from secure endpoint";
    }

}
