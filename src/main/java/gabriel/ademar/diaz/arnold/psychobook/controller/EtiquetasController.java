package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Etiquetas;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.EtiquetasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
public class EtiquetasController {

    private final EtiquetasService etiquetasService;

    public EtiquetasController(EtiquetasService etiquetasService) {
        this.etiquetasService = etiquetasService;
    }

    @GetMapping
    public List<Etiquetas> getAllEtiquetas() {
        return etiquetasService.getAllEtiquetas();
    }
}
