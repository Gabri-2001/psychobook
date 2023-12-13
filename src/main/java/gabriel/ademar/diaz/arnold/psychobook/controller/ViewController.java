package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;
import gabriel.ademar.diaz.arnold.psychobook.entities.Especialidades;
import gabriel.ademar.diaz.arnold.psychobook.entities.Etiquetas;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
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
        String city = "Elche";
        model.addAttribute("city", city);
        return "listado_psicologos";
    }

    @GetMapping("/listado_centros")
    public String listado_centros(Model model) {

        Set<Especialidades> especialidadesUnicas = psicologosService.obtenerEspecialidadesUnicas();

        List<Psicologos> psicologos = psicologosController.getAllPsicologos();

        List<Centros> centros = centrosController.getAllCentros();

        model.addAttribute("centros", centros);
        model.addAttribute("especialidades", especialidadesUnicas);
        return "listado_psicologos";
    }
    @GetMapping("/listado_psicologos")
    public String listado_psicologos( Model model, @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {

        Page<Psicologos> psicologos = psicologosController.getAllPagePsicologos(page,size);
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();

        model.addAttribute("psicologosPage", psicologos);
        model.addAttribute("etiquetas", etiquetas);
        return "listado_psicologos";
    }

    @GetMapping("psicologos/buscarPorLocalidad")
    public String buscarPsicologosPorLocalidad(@RequestParam String localidad,@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size, Model model) {
        if(localidad.equals("")){
            return "redirect:/listado_psicologos";
        }
        else {
            Page<Psicologos> psicologosPage = psicologosController.psicologosByLocalidad(localidad, page, size);
            List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();
            model.addAttribute("psicologosPage", psicologosPage);
            model.addAttribute("etiquetas", etiquetas);
            model.addAttribute("localidad", localidad);
            return "resultadosBusqueda";
        }


    }

    @GetMapping("psicologos/etiqueta/{etiqueta}")
    public String mostrarPsicologosPorEtiqueta(@PathVariable("etiqueta") String etiqueta, @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size, Model model) {
        Page<Psicologos> psicologosPage = psicologosController.psicologosByEtiqueta(etiqueta, page, size);
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();
        model.addAttribute("psicologosPage", psicologosPage);
        model.addAttribute("etiquetas", etiquetas);
        model.addAttribute("etiqueta", etiqueta);
        return "psicologosPorEtiqueta"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("/psicologos/detalle/{id}")
    public String mostrarDetallePsicologo(@PathVariable Long id, Model model) {
        Psicologos psicologos = psicologosController.mostrarDetallePsicologo(id);
        model.addAttribute("psicologos", psicologos);
        return "detallesPsicologo";
    }

    @GetMapping("/admin")
    public String index_admin() {
        return "index_admin";
    }

    @GetMapping("/listado_psicologos_admin")
    public String admin_listado_psicologos( Model model) {


        List<Psicologos> psicologos = psicologosController.getAllPsicologos();
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();


        model.addAttribute("psicologos", psicologos);
        model.addAttribute("etiquetas", etiquetas);
        return "listado_psicologos_admin";
    }



    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("psicologo", new Psicologos());
        return "registroPsicologo";
    }

    @PostMapping("/psicologos/guardar")
    public String guardarPsicologo(
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam String localidad,
            @RequestParam(required = false) MultipartFile imagenFile,
            RedirectAttributes redirectAttributes) {

        Psicologos psicologo = new Psicologos();
        psicologo.setNombre(nombre);
        psicologo.setDescripcion(descripcion);
        psicologo.setLocalidad(localidad);
        if (imagenFile != null && !imagenFile.isEmpty()) {
            try {
                psicologo.setImagen(imagenFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        psicologosController.guardarPsicologo(psicologo);
        redirectAttributes.addFlashAttribute("message", "Psicólogo guardado con éxito");
        return "redirect:/nuevo";
    }
}
