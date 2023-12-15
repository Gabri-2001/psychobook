package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import gabriel.ademar.diaz.arnold.psychobook.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/psicologos")
public class PsicologosController {

    private final PsicologosService psicologoService;
    private final UsersService usersService;

    public PsicologosController(PsicologosService psicologoService, UsersService usersService) {
        this.psicologoService = psicologoService;
        this.usersService = usersService;
    }

    @GetMapping("/psicologosfindAll")
    public List<Psicologos> getAllPsicologos() {
        return psicologoService.getAllPsicologos();
    }

    @GetMapping("/psicologosPage")
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

    @GetMapping("psicologosByNombre")
    public Page<Psicologos> psicologosByNombre(@RequestParam String nombre, @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return psicologoService.getByNombre(nombre, pageable);
    }

    @GetMapping("/psicologo/detalle/{id}")
    public Psicologos mostrarDetallePsicologo(@PathVariable Long id) {
        return psicologoService.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public Psicologos   guardarPsicologo(@ModelAttribute Psicologos psicologo) {

        return psicologoService.guardarPsicologo(psicologo);
    }

    @PostMapping("/update")
    public void updatePsicologo(@ModelAttribute Psicologos psicologo) {

        psicologoService.updatePsicologo(psicologo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePsicologo(@PathVariable Long id) {
        try {
            Psicologos psicologos = psicologoService.buscarPorId(id);
            psicologoService.deletePsicologo(id);
            usersService.deleteUser(psicologos.getUser().getId());
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Mensaje("Error al eliminar el psicólogo"));
        }
    }

    private static class Mensaje {
        private String mensaje;

        public Mensaje(String mensaje) {
            this.mensaje = mensaje;
        }

}

}
