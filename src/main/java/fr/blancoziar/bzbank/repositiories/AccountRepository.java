
package fr.blancoziar.bzbank.repositiories;

import fr.blancoziar.bzbank.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}

