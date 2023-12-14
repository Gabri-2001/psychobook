package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.repository.EspecialidadesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadesServiceImpl implements EspecialidadesService{

    final EspecialidadesRepository especialidadesRepository;

    public EspecialidadesServiceImpl(EspecialidadesRepository especialidadesRepository) {
        this.especialidadesRepository = especialidadesRepository;
    }

    @Override
    public List<Especialidades> getAllEspecialidades() {
        return especialidadesRepository.findAll();
    }
}
