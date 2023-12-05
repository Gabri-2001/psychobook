package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Clientes;
import gabriel.ademar.diaz.arnold.psychobook.entities.Psicologos;
import gabriel.ademar.diaz.arnold.psychobook.service.ClientesService;
import gabriel.ademar.diaz.arnold.psychobook.service.PsicologosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final ClientesService clienteService;

    public ClientesController(ClientesService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Clientes> getAllClientes() {
        return clienteService.getAllClientes();
    }


}
