package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Clientes;
import gabriel.ademar.diaz.arnold.psychobook.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService{


    private final ClientesRepository clientesRepository;

    public ClientesServiceImpl(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }


    @Override
    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes guardarCliente(Clientes clientes) {
        return clientesRepository.save(clientes);
    }
}
