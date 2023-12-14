package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;
import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.service.EspecialidadesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadesController {

    private final EspecialidadesService especialidadesService;

    public EspecialidadesController(EspecialidadesService especialidadesService) {
        this.especialidadesService = especialidadesService;
    }

    @GetMapping("/findAllEspecialidades")
    public List<Especialidades> getAllEspecialidades() {
        return especialidadesService.getAllEspecialidades();
    }
}
