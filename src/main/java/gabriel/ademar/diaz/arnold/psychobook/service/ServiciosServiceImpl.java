package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Servicios;
import gabriel.ademar.diaz.arnold.psychobook.repository.ServiciosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosServiceImpl implements ServiciosService{

    private final ServiciosRepository serviciosRepository;

    public ServiciosServiceImpl(ServiciosRepository serviciosRepository) {
        this.serviciosRepository = serviciosRepository;
    }

    @Override
    public List<Servicios> getAllServicios() {
        return serviciosRepository.findAll();
    }

}
