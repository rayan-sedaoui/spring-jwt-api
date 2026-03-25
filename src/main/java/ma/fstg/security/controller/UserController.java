package ma.fstg.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

   @GetMapping("/users")
    public ResponseEntity<List<String>> getUsers() {
        List<String> fakeUsers = List.of("Utilisateur_1_Test", "Utilisateur_2_Test", "Bravo_Ca_Marche");
        return ResponseEntity.ok(fakeUsers);
    }
}