package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Clientes;
import gabriel.ademar.diaz.arnold.psychobook.repository.ClientesRepository;
import gabriel.ademar.diaz.arnold.psychobook.repository.PsicologosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServicesImpl implements ClientesService{


    private final ClientesRepository clientesRepository;

    public ClientesServicesImpl(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }


    @Override
    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }
}
