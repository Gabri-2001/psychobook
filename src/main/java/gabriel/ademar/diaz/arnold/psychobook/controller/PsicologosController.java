package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("psicologosPage")
    public Page<Psicologos> getAllPagePsicologos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return psicologoService.getAllPsicologos(pageable);
    }


    @GetMapping("psicologosByLocalidad")
    public Page<Psicologos> psicologosByLocalidad(@RequestParam String localidad, @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return psicologoService.buscarPorLocalidad(localidad, pageable);
    }

    @GetMapping("psicologosByEtiqueta")
    public Page<Psicologos> psicologosByEtiqueta(@RequestParam String etiqueta, @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return psicologoService.buscarPorEtiqueta(etiqueta, pageable);
    }

    @GetMapping("/psicologo/detalle/{id}")
    public Psicologos mostrarDetallePsicologo(@PathVariable Long id) {
        return psicologoService.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public Psicologos   guardarPsicologo(@ModelAttribute Psicologos psicologo) {

        return psicologoService.guardarPsicologo(psicologo);
    }

}
