package fr.blancoziar.bzbank.repositiories;

import fr.blancoziar.bzbank.Entities.AuthToken;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepository extends JpaRepository<AuthToken, String> {
    List<AuthToken> findByUserId(Integer user); 
}
