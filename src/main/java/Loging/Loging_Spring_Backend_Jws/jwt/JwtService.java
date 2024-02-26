package Loging.Loging_Spring_Backend_Jws.jwt;

import Loging.Loging_Spring_Backend_Jws.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String getToken(UserDetails user) {
        return null;
    }
}
