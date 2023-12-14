package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;

import java.util.List;
import java.util.Optional;

public interface CentrosService {

    List<Centros> getAllCentros();

    List<Centros> findAllByOrderByNombreAsc();

    Optional<Centros> findById(Long id);


}
