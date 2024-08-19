package fr.ln.nextLine.config.Security.ControllerSecurity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Crée une demande d'authentification
            Authentication authenticationRequest =
                    new UsernamePasswordAuthenticationToken(loginRequest.login(), loginRequest.password());

            // Authentifie l'utilisateur
            Authentication authenticationResponse =
                    this.authenticationManager.authenticate(authenticationRequest);

            // Gère la réussite de l'authentification
            // Pour l'instant, retourne un message de succès
            // Plus tard, tu ajouteras ici la génération du JWT
            return ResponseEntity.ok("Authentication successful");

        } catch (BadCredentialsException e) {
            // Gère l'échec de l'authentification
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception e) {
            // Gère les autres exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    public record LoginRequest(String login, String password) {

    }

}

