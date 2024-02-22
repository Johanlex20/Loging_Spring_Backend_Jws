package Loging.Loging_Spring_Backend_Jws.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})

public class User {

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

}
