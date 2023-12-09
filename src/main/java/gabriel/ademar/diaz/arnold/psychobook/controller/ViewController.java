package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;
import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller

@RequestMapping("/")
public class ViewController {

    @Autowired
    PsicologosController psicologosController;

    @Autowired
    CentrosController centrosController;

    @Autowired
    private PsicologosService psicologosService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/psychologists")
    public String showPsychologists(Model model) {
        String city = "Elche"; // Esto podría venir de una base de datos o ser dinámico
        model.addAttribute("city", city);
        // Agrega más atributos al modelo como sea necesario
        return "prueba1"; // Nombre de la plantilla HTML
    }

    @GetMapping("/listado_psicologos")
    public String listado_psicologos(Model model) {

        Set<Especialidades> especialidadesUnicas = psicologosService.obtenerEspecialidadesUnicas();

        List<Psicologos> psicologos = psicologosController.getAllPsicologos();

        List<Centros> centros = centrosController.getAllCentros();

        model.addAttribute("centros", centros);
        model.addAttribute("especialidades", especialidadesUnicas);
        return "prueba1";
    }

    @GetMapping("/admin")
    public String index_admin() {
        return "index_admin";
    }
}
