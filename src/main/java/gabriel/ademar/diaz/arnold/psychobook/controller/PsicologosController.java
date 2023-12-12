package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("psicologosByLocalidad")
    public List<Psicologos> psicologosByLocalidad(@RequestParam String localidad) {
        return psicologoService.buscarPorLocalidad(localidad);
    }

    @GetMapping("psicologosByEtiqueta")
    public List<Psicologos> psicologosByEtiqueta(@RequestParam String etiqueta) {
        return psicologoService.buscarPorEtiqueta(etiqueta);
    }
}
