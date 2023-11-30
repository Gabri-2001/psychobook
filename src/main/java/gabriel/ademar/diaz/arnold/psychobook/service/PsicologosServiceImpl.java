package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.repository.PsicologosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsicologosServiceImpl implements PsicologosService{

    private final PsicologosRepository psicologosRepository;

    public PsicologosServiceImpl(PsicologosRepository psicologosRepository) {
        this.psicologosRepository = psicologosRepository;
    }

    @Override
    public List<Psicologos> obtenerTodosLosPsicologos() {
        return psicologosRepository.findAll();
    }

    @Override
    public Psicologos guardarPsicologo(Psicologos psicologo) {
        // Lógica de negocios adicional si es necesario
        return psicologosRepository.save(psicologo);
    }

}