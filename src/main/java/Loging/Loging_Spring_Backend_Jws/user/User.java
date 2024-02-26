package Loging.Loging_Spring_Backend_Jws.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// 8 - Agregar las Anotaciones @Entity

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})

// 8.2 Implementar funcion del sistema UserDetails para trabajar con la autenticacion

public class User implements UserDetails {

// 8.1 - Crear Variables y generar Anotaciones 

    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String username;
    String lastname;
    String firstname;
    String country;
    String password;
    Role role;

    // 8.4 - Retornar la lista con el role

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name())); //lista un unico objeto que asigna un role autenticado
    }

    // 8.3 - modificar los metodos por defecto a TRUE

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
