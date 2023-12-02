package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;

import java.util.List;

public interface PsicologosService {
    List<Psicologos> getAllPsicologos();
    Psicologos guardarPsicologo(Psicologos psicologo);
}
