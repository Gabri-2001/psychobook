package gabriel.ademar.diaz.arnold.psychobook.repository;

import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);



}
