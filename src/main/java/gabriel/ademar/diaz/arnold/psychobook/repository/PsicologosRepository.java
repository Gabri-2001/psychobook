package gabriel.ademar.diaz.arnold.psychobook.repository;

import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PsicologosRepository extends JpaRepository<Psicologos, Long> {

    Page<Psicologos> findByLocalidad(String localidad, Pageable pageable);

    Page<Psicologos> findByEtiquetasNombre(String nombreEtiqueta, Pageable pageable);

    Page<Psicologos> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
}
