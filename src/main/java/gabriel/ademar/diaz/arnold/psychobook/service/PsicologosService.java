package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface PsicologosService {
    List<Psicologos> getAllPsicologos();
    Psicologos guardarPsicologo(Psicologos psicologo);
    Set<Especialidades> obtenerEspecialidadesUnicas();
    Page<Psicologos> buscarPorLocalidad(String localidad, Pageable pageable);
    Page<Psicologos> buscarPorEtiqueta(String etiqueta, Pageable pageable);
    Psicologos buscarPorId(Long id);
    Page<Psicologos> getAllPsicologos(Pageable pageable);
}
