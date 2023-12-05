package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Resenyas;
import gabriel.ademar.diaz.arnold.psychobook.repository.ResenyasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenyasServiceImpl implements ResenyasService{

    private final ResenyasRepository resenyasRepository;

    public ResenyasServiceImpl(ResenyasRepository resenyasRepository) {
        this.resenyasRepository = resenyasRepository;
    }

    @Override
    public List<Resenyas> getAllResenyas() {
        return resenyasRepository.findAll();
    }
}
