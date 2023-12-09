package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/psicologos")
public class PsicologosController {

    private final PsicologosService psicologoService;

    public PsicologosController(PsicologosService psicologoService) {
        this.psicologoService = psicologoService;
    }

    @GetMapping
    public List<Psicologos> getAllPsicologos() {
        return psicologoService.getAllPsicologos();
    }

}
