package gabriel.ademar.diaz.arnold.psychobook.controller;

import gabriel.ademar.diaz.arnold.psychobook.entities.Users;
import gabriel.ademar.diaz.arnold.psychobook.service.UsersService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
    public Optional<Users> findUserByEmail(String email){
        return usersService.findUserByEmail(email);
    }

 /*
    @PostMapping("/login")
    public void login(HttpServletResponse response, @ModelAttribute Users user)
            throws NoSuchAlgorithmException, IOException {
        Optional<Users> usuario = usersService.findUserByEmail(user.getEmail());
        if (usuario.isPresent()) {

            response.sendRedirect("/login_user");
        }

        String token = JWTHandler.createToken(user.getEmail(), user.getRol(), user.getId());
        AuthCookie cookie = new AuthCookie(token);
        cookie.setPath("/");
        response.addCookie(cookie);
        System.out.println("Token created");
        System.out.println(user.getRol());


        if(user.getRol().equals("admin")){
            response.sendRedirect("/admin");
        }
        else {
            response.sendRedirect("/index");
        }

    } */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            usersService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new UsersController.Mensaje("Error al eliminar el psicólogo"));
        }
    }

    private static class Mensaje {
        private String mensaje;

        public Mensaje(String mensaje) {
            this.mensaje = mensaje;
        }

    }
}
