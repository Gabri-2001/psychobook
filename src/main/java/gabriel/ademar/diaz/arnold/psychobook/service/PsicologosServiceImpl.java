package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.repository.PsicologosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
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

    @Override
    public Page<Psicologos> buscarPorLocalidad(String localidad, Pageable pageable) {
        return psicologosRepository.findByLocalidad(localidad, pageable);

    }
    @Override
    public Page<Psicologos> buscarPorEtiqueta(String etiqueta, Pageable pageable) {
        return psicologosRepository.findByEtiquetasNombre(etiqueta, pageable);
    }

    @Override
    public Psicologos buscarPorId(Long id) {
        return psicologosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Psicólogo no encontrado con el ID: " + id));
    }

    public Page<Psicologos> getAllPsicologos(Pageable pageable) {
        return psicologosRepository.findAll(pageable);
    }

    @Override
    public void deletePsicologo(Long id) {

        Psicologos psicologo = psicologosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Psicólogo no encontrado con ID: " + id));
        psicologosRepository.delete(psicologo);
    }

    @Override
    public void updatePsicologo(Psicologos psicologo) {
        psicologosRepository.save(psicologo);
    }

    @Override
    public Page<Psicologos> getByNombre(String nombre, Pageable pageable) {
        return psicologosRepository.findByNombreContainingIgnoreCase(nombre, pageable);
    }


}