package gabriel.ademar.diaz.arnold.psychobook.repository;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EspecialidadesRepository extends JpaRepository<Especialidades, Long> {
}
