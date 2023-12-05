package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Resenyas;
import gabriel.ademar.diaz.arnold.psychobook.entities.Servicios;
import gabriel.ademar.diaz.arnold.psychobook.service.ServiciosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServiciosController {

    private final ServiciosService serviciosService;

    public ServiciosController(ServiciosService serviciosService) {
        this.serviciosService = serviciosService;
    }

    @GetMapping
    public List<Servicios> getAllServicios() {
        return serviciosService.getAllServicios();
    }
}
