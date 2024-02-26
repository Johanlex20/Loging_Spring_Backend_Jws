package Loging.Loging_Spring_Backend_Jws.jwt;

import Loging.Loging_Spring_Backend_Jws.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// 9 - Agregar anotacion @Service

@Service
public class JwtService {

// 11.3 - Instanciamos variable estatica SECRET_KEY    
    private static final String SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

// 9.1 - Cambiamos el Objeto user a UserDetails

    public String getToken(UserDetails user) {

// 11.1 - retornar funcion getToken con HashMap
        return getToken(new HashMap<>(), user);  
    }

// 11.2 - Implementar Metodo getToken() con Map

    private String getToken(Map<String,Object> extraClaims, UserDetails user) {
        return Jwts   // 11.3 - usar libreria Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

// 11.4 - Implementar el metodo getKey()  

    private Key getKey() {
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY); // usar la clase Decoders.BASE64.decode
        return Keys.hmacShaKeyFor(keyBytes);  //retornar con hmacShaKeyFor
    }

// 18.2 - 
    public String getUsernameFromToken(String token) {
        return getClaim(token,Claims::getSubject);
    }

// 18.4 - Implentar isTokenValid    

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

// 18.1 - Crear metodo privado que obtiene todos los Claims del token

    private Claims getAllClains(String token){
        return  Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

// 18.2 -  Obtener un Claim

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClains(token);
        return claimsResolver.apply(claims);
    }

// 18.3 - Obtener fiecha de expiracion    

    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }

}
