package gabriel.ademar.diaz.arnold.psychobook.repository;

import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.entities.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ServiciosRepository extends JpaRepository<Servicios, Long> {
}
