package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.repository.PsicologosRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PsicologosServiceImpl implements PsicologosService{

    private final PsicologosRepository psicologosRepository;

    public PsicologosServiceImpl(PsicologosRepository psicologosRepository) {
        this.psicologosRepository = psicologosRepository;
    }

    @Override
    public List<Psicologos> getAllPsicologos() {
        return psicologosRepository.findAll();
    }

    @Override
    public Psicologos guardarPsicologo(Psicologos psicologo) {
        // Lógica de negocios adicional si es necesario
        return psicologosRepository.save(psicologo);
    }

    @Override
    public Set<Especialidades> obtenerEspecialidadesUnicas() {
        List<Psicologos> psicologos = psicologosRepository.findAll();
        Set<Especialidades> especialidadesUnicas = new HashSet<>();

        for (Psicologos psicologo : psicologos) {
            especialidadesUnicas.addAll(psicologo.getEspecialidades());
        }
        return especialidadesUnicas;

    }


}