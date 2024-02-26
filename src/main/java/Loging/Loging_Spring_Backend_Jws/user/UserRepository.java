package Loging.Loging_Spring_Backend_Jws.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 8 -Interface y Extender JpaRepository

public interface UserRepository extends JpaRepository<User, Integer> {

// 8.1 - Metodo Optional QueryMetodos

    Optional<User> findByUsername(String username);
}
