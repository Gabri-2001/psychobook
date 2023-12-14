package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;
import gabriel.ademar.diaz.arnold.psychobook.entities.Clientes;
import gabriel.ademar.diaz.arnold.psychobook.service.CentrosService;
import gabriel.ademar.diaz.arnold.psychobook.service.ClientesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/centros")
public class CentrosController {

    private final CentrosService centrosService;

    public CentrosController(CentrosService centrosService) {
        this.centrosService = centrosService;
    }

    @GetMapping("/findAllCentros")
    public List<Centros> getAllCentros() {
        return centrosService.getAllCentros();
    }

    @GetMapping("/findAllCentrosByNombresAsc")
    public List<Centros> getAllCentrosByNombreAsc() {
        return centrosService.findAllByOrderByNombreAsc();
    }

    @GetMapping("/{id}")
    public Optional<Centros> getCentrosById(@PathVariable Long id) {
        return centrosService.findById(id);
    }
}
