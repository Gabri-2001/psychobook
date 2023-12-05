package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Clientes;
import gabriel.ademar.diaz.arnold.psychobook.entities.Resenyas;
import gabriel.ademar.diaz.arnold.psychobook.service.ClientesService;
import gabriel.ademar.diaz.arnold.psychobook.service.ResenyasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/resenyas")
public class ResenyasController {

    private final ResenyasService resenyaService;

    public ResenyasController(ResenyasService resenyaService) {
        this.resenyaService = resenyaService;
    }

    @GetMapping
    public List<Resenyas> getAllResenyas() {
        return resenyaService.getAllResenyas();
    }

}
