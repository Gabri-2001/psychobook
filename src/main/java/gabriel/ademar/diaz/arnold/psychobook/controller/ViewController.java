package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;
import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Etiquetas;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    EtiquetasController etiquetasController;

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

    @GetMapping("/listado_centros")
    public String listado_centros(Model model) {

        Set<Especialidades> especialidadesUnicas = psicologosService.obtenerEspecialidadesUnicas();

        List<Psicologos> psicologos = psicologosController.getAllPsicologos();

        List<Centros> centros = centrosController.getAllCentros();

        model.addAttribute("centros", centros);
        model.addAttribute("especialidades", especialidadesUnicas);
        return "prueba1";
    }
    @GetMapping("/listado_psicologos")
    public String listado_psicologos( Model model) {


        List<Psicologos> psicologos = psicologosController.getAllPsicologos();
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();


        model.addAttribute("psicologos", psicologos);
        model.addAttribute("etiquetas", etiquetas);
        return "prueba1";
    }

    @PostMapping("psicologos/buscarPorLocalidad")
    public String buscarPsicologosPorLocalidad(@RequestParam String localidad, Model model) {
        List<Psicologos> psicologos = psicologosController.psicologosByLocalidad(localidad);
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();
        model.addAttribute("psicologos", psicologos);
        model.addAttribute("etiquetas", etiquetas);
        model.addAttribute("localidad", localidad);
        return "resultadosBusqueda";
    }

    @GetMapping("psicologos/etiqueta/{etiqueta}")
    public String mostrarPsicologosPorEtiqueta(@PathVariable("etiqueta") String etiqueta, Model model) {
        List<Psicologos> psicologos = psicologosController.psicologosByEtiqueta(etiqueta);
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();
        model.addAttribute("psicologos", psicologos);
        model.addAttribute("etiquetas", etiquetas);
        model.addAttribute("etiqueta", etiqueta);
        return "psicologosPorEtiqueta"; // Nombre de la plantilla Thymeleaf
    }


    @GetMapping("/admin")
    public String index_admin() {
        return "index_admin";
    }
}
