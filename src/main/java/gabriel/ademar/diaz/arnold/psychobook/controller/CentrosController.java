package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;
import gabriel.ademar.diaz.arnold.psychobook.entities.Clientes;
import gabriel.ademar.diaz.arnold.psychobook.service.CentrosService;
import gabriel.ademar.diaz.arnold.psychobook.service.ClientesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/centros")
public class CentrosController {

    private final CentrosService centrosService;

    public CentrosController(CentrosService centrosService) {
        this.centrosService = centrosService;
    }

    @GetMapping
    public List<Centros> getAllCentros() {
        return centrosService.getAllCentros();
    }
}
