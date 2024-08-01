package fr.ln.nextLine.config.Security.ControllerSecurity;

import fr.ln.nextLine.config.Security.JwtUtil;
import fr.ln.nextLine.config.Security.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final JwtUtil jwtUtil;

    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Logger logger = LoggerFactory.getLogger(getClass());

        logger.info("Authenticating user: {}", loginRequest);

        try {
            // Crée une demande d'authentification avec login et password
            Authentication authenticationRequest =
                    new UsernamePasswordAuthenticationToken(loginRequest.login(), loginRequest.password());

            // Authentifie l'utilisateur
            Authentication authenticationResponse =
                    this.authenticationManager.authenticate(authenticationRequest);

            // Génère le JWT après une authentification réussie
            String jwtToken = jwtUtil.generateToken(loginRequest.login());
            logger.info("Token generated: {}", jwtToken);


            // Retourne le JWT dans la réponse
            return ResponseEntity.ok(jwtToken);

        } catch (BadCredentialsException e) {
            // Gère l'échec de l'authentification
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception e) {
            // Gère les autres exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
