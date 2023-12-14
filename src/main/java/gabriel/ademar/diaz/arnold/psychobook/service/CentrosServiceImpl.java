package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;
import gabriel.ademar.diaz.arnold.psychobook.repository.CentrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentrosServiceImpl implements CentrosService{

    private final CentrosRepository centrosRepository;

    public CentrosServiceImpl(CentrosRepository centrosRepository) {
        this.centrosRepository = centrosRepository;
    }

    @Override
    public List<Centros> getAllCentros() {
        return centrosRepository.findAll();
    }

    @Override
    public List<Centros> findAllByOrderByNombreAsc() {
        return centrosRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public Optional<Centros> findById(Long id) {
        return centrosRepository.findById(id);
    }
}
