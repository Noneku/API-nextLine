package fr.ln.nextLine.config.Security;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public AuthUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateurFoundByLogin = utilisateurRepository.findByutilisateurLogin(login);

        if (utilisateurFoundByLogin.isPresent()) {
            Utilisateur utilisateur = utilisateurFoundByLogin.get();

            // Log les détails de l'utilisateur (sans mot de passe en production)
            logger.info("Utilisateur trouvé : Login = {}", utilisateur.toString());
            return new CustomUserDetails(utilisateur);
        } else {
            logger.warn("Utilisateur non trouvé : {}", login);
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}
