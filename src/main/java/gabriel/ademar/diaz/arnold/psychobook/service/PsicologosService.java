package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;

import java.util.List;
import java.util.Set;

public interface PsicologosService {
    List<Psicologos> getAllPsicologos();
    Psicologos guardarPsicologo(Psicologos psicologo);
    Set<Especialidades> obtenerEspecialidadesUnicas();
}
