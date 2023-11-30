package gabriel.ademar.diaz.arnold.psychobook.repository;

import gabriel.ademar.diaz.arnold.psychobook.entities.Etiquetas;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EtiquetasRepository extends JpaRepository<Etiquetas, Long> {
}
