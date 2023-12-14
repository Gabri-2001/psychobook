package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.*;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.ManyToOne;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
    UsersController usersController;

    @Autowired
    EspecialidadesController especialidadesController;

    @Autowired
    ClientesController clientesController;

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

    @GetMapping("psicologos/localidad")
    public String psicologosByLocalidad(@RequestParam String localidad,@RequestParam(defaultValue = "0") int page,
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
            return "psicologosByLocalidad";
        }
    }

    @GetMapping("psicologos/etiqueta/{etiqueta}")
    public String psicologosByEtiqueta(@PathVariable("etiqueta") String etiqueta, @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size, Model model) {
        Page<Psicologos> psicologosPage = psicologosController.psicologosByEtiqueta(etiqueta, page, size);
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();
        model.addAttribute("psicologosPage", psicologosPage);
        model.addAttribute("etiquetas", etiquetas);
        model.addAttribute("etiqueta", etiqueta);
        return "psicologosByEtiqueta"; // Nombre de la plantilla Thymeleaf
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
    public String listado_psicologos_admin( Model model, @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {

        Page<Psicologos> psicologos = psicologosController.getAllPagePsicologos(page,size);
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();

        model.addAttribute("psicologosPage", psicologos);
        model.addAttribute("etiquetas", etiquetas);
        return "listado_psicologos_admin";
    }

    @GetMapping("psicologos_admin/etiqueta/{etiqueta}")
    public String PsicologosByEtiqueta_admin(@PathVariable("etiqueta") String etiqueta, @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size, Model model) {
        Page<Psicologos> psicologosPage = psicologosController.psicologosByEtiqueta(etiqueta, page, size);
        List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();
        model.addAttribute("psicologosPage", psicologosPage);
        model.addAttribute("etiquetas", etiquetas);
        model.addAttribute("etiqueta", etiqueta);
        return "psicologosByEtiqueta_admin"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("psicologos_admin/localidad")
    public String psicologosByLocalidad_admin(@RequestParam String localidad,@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size, Model model) {
        if(localidad.equals("")){
            return "redirect:/listado_psicologos_admin";
        }
        else {
            Page<Psicologos> psicologosPage = psicologosController.psicologosByLocalidad(localidad, page, size);
            List<Etiquetas> etiquetas = etiquetasController.getAllEtiquetas();
            model.addAttribute("psicologosPage", psicologosPage);
            model.addAttribute("etiquetas", etiquetas);
            model.addAttribute("localidad", localidad);
            return "psicologosByLocalidad_admin";
        }
    }



    @GetMapping("/psicologos_admin/crear_usuario")
    public String registroUsuario(Model model) {
        model.addAttribute("user", new Users());
        return "registroUsuario";
    }

    @GetMapping("/psicologos_admin/crear_psicologo/{userId}")
    public String registroPsicologo(@PathVariable("userId") Long userId, Model model) {
        Psicologos psicologo = new Psicologos();
        Optional<Users> user = usersController.findUserById(userId);
        List<Centros> centros = centrosController.getAllCentros();
        List<Especialidades> especialidades = especialidadesController.getAllEspecialidades();
        List<Centros> sortedUniqueCentros = centros.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Centros::getNombre))),
                        ArrayList::new));
        if (user.isPresent()) {
            psicologo.setUser(user.get());
            model.addAttribute("psicologo", psicologo);
            model.addAttribute("centros", sortedUniqueCentros);
            model.addAttribute("especialidades", especialidades);
            return "registroPsicologo";
        }
        else {
            return "registroUsuario";
        }
    }

    @GetMapping("/psicologos_admin/crear_cliente/{userId}")
    public String registroCliente(@PathVariable("userId") Long userId, Model model) {
        Clientes cliente = new Clientes();
        Optional<Users> user = usersController.findUserById(userId);
        if (user.isPresent()) {
            cliente.setUser(user.get());
            model.addAttribute("cliente", cliente);
            return "registroCliente";
        }
        else{
            return "registroUsuario";
        }

    }

    @PostMapping("/usuario/guardar")
    public String saveUser(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String rol, RedirectAttributes redirectAttributes, Model model){

        System.out.println(email);
        System.out.println(password);
        System.out.println(rol);

        Users user = new Users();
        user.setEmail(email);
        user.setPassword(password);
        user.setRol(rol);
        if (usersController.emailDuplicate(user.getEmail())) {
            model.addAttribute("emailDuplicate", true);
            model.addAttribute("errorMessage", "El email ya está en uso.");
            model.addAttribute("user", new Users());
            return "registroUsuario";
        }
        else {
            Users user_guardado = usersController.saveUser(user);

            redirectAttributes.addAttribute("userId", user_guardado.getId());

            if(user.getRol().equals("psicologo")){
                return "redirect:/psicologos_admin/crear_psicologo/{userId}";
        }
            else{
                return "redirect:/psicologos_admin/crear_cliente/{userId}";
            }
        }
    }

    @PostMapping("/psicologos/guardar")
    public String guardarPsicologo(
            @ModelAttribute Psicologos psicologo,
            RedirectAttributes redirectAttributes) {

        psicologo.setValidado(false);

        System.out.println(psicologo.getId());
        System.out.println(psicologo.getUser());
        System.out.println(psicologo.getNombre());
        System.out.println(psicologo.getUser().getId());

        psicologosController.guardarPsicologo(psicologo);
        redirectAttributes.addFlashAttribute("message", "Psicólogo guardado con éxito");
        return "redirect:/listado_psicologos_admin";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(
            @ModelAttribute Clientes clientes,
            RedirectAttributes redirectAttributes) {


        System.out.println(clientes.getId());
        System.out.println(clientes.getNombre());
        System.out.println(clientes.getUser());
        System.out.println(clientes.getUser().getId());

        clientesController.guardarCliente(clientes);
        redirectAttributes.addFlashAttribute("message", "Psicólogo guardado con éxito");
        return "redirect:/listado_psicologos_admin";
    }


    // Método para eliminar después de la confirmación
    @PostMapping("/delete/{id}")
    public String deletePsicologo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            psicologosService.deletePsicologo(id);
            redirectAttributes.addFlashAttribute("success", "El psicólogo ha sido eliminado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Hubo un problema al eliminar el psicólogo.");
        }
        return "redirect:/psicologos_list_admin";
    }
}
