package gabriel.ademar.diaz.arnold.psychobook.service;

import gabriel.ademar.diaz.arnold.psychobook.entities.Users;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<Users> getAllUsers();

    Users saveUser(Users user);

    Optional<Users> findUserById(Long id);

    boolean emailDuplicate(String email);

    void deleteUser(Long id);



}
