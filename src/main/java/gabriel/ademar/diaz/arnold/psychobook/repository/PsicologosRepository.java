package gabriel.ademar.diaz.arnold.psychobook.repository;

import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PsicologosRepository extends JpaRepository<Psicologos, Long> {

    List<Psicologos> findByLocalidad(String localidad);

    List<Psicologos> findByEtiquetasNombre(String nombreEtiqueta);
}
