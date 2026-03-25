package ma.fstg.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/user/profile")
    public String userProfile() {
        return "Profil Utilisateur : Bravo, votre Token JWT est valide et vous avez accès !";
    }

    @GetMapping("/api/admin/dashboard")
    public String adminDashboard() {
        return "Dashboard Admin : Accès autorisé uniquement pour les administrateurs.";
    }
}