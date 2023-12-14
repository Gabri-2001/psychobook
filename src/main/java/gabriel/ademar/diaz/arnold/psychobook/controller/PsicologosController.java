package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/psicologosfindAll")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePsicologo(@PathVariable Long id) {
        try {
            psicologoService.deletePsicologo(id);
            return new ResponseEntity<>(new Mensaje("Psicólogo eliminado correctamente"), HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new Mensaje("Psicólogo no encontrado"), HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(new Mensaje("No se puede eliminar el psicólogo debido a restricciones de la base de datos"), HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(new Mensaje("Error al eliminar el psicólogo"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static class Mensaje {
        private String mensaje;

        public Mensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        // Getter y Setter

}

}
