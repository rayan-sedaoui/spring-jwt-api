
package ma.fstg.security.repositories;

import ma.fstg.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Spring va comprendre tout seul qu'il doit chercher par la colonne username !
}