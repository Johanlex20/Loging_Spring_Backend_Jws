package Loging.Loging_Spring_Backend_Jws.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// 4- Agregar las Anotaciones @Component y Extender OncePerRequestFilter (Filtro que se ejecuta una vez por Http)

@Component
@RequiredArgsConstructor

public class JwtAuthenticationFilter extends OncePerRequestFilter {


// 17.1 - Agregamos los Servicios de jws y config

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

// 4.1 - Implementar El metodo doFilterInternal 

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String token = getTokenFromRequest(request); // 4.2 - Creamos la variable
        final String username; // 17.2 instanciamos username

        if (token == null){                               // 4.3 - Creamos el condicional  
            filterChain.doFilter(request,response);
            return;
        }

// 17.3 - Acceder username del Token 
        username=jwtService.getUsernameFromToken(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
// 17.4 - validar si el Token es valido con isTokenValid            
            if (jwtService.isTokenValid(token, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( 
                        userDetails,
                        null,
                        userDetails.getAuthorities());
// 17.5 Setear la instancia
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request,response);

    }

    private String getTokenFromRequest(HttpServletRequest request) {            // 4.4 Implementados el Metodo getTokenFromRequest 
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(authHeader)&& authHeader.startsWith("Bearer")){ // hastext verifica si es empy o no
            return authHeader.substring(7);//substring muestra despues del caracter 7
        }
        return null;
    }
}
