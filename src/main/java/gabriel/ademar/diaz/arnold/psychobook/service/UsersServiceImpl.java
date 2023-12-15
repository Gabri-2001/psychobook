package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Users;
import gabriel.ademar.diaz.arnold.psychobook.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Optional<Users> findUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + id));
        usersRepository.delete(user);
    }

    @Override
    public Optional<Users> findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
