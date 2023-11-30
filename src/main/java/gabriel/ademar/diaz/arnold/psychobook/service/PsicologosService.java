package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;

import java.util.List;

public interface PsicologosService {
    List<Psicologos> obtenerTodosLosPsicologos();
    Psicologos guardarPsicologo(Psicologos psicologo);
}
