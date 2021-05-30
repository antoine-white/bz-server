
package fr.blancoziar.bzbank.repositiories;

import fr.blancoziar.bzbank.Entities.BankUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankUserRepository extends JpaRepository<BankUser, Integer> {

}

