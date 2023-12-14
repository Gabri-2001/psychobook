package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Centros;
import gabriel.ademar.diaz.arnold.psychobook.entities.Users;
import gabriel.ademar.diaz.arnold.psychobook.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/listado_users")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping("/user/save")
    public Users saveUser(@ModelAttribute Users user) {
        return usersService.saveUser(user);
    }

    @GetMapping("/findUserById")
    public Optional<Users> findUserById(Long id){
        return usersService.findUserById(id);
    }

    @GetMapping("/findUserByEmail")
    public Boolean emailDuplicate(String email){
        return usersService.emailDuplicate(email);
    }
}
