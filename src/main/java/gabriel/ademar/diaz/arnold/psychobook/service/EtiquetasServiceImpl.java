package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Etiquetas;
import gabriel.ademar.diaz.arnold.psychobook.repository.EtiquetasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetasServiceImpl implements EtiquetasService{
    private final EtiquetasRepository etiquetasRepository;

    public EtiquetasServiceImpl(EtiquetasRepository etiquetasRepository) {
        this.etiquetasRepository = etiquetasRepository;
    }

    @Override
    public List<Etiquetas> getAllEtiquetas() {
        return etiquetasRepository.findAll();
    }
}
