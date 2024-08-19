package fr.ln.nextLine.config.Security;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/*
    La classe SessionUserDetails encapsule les informations spécifiques à l'utilisateur lors de son authentification
    pour fournir ces informations à Spring Security de manière structurée.
 */

public class SessionUserDetails implements UserDetails {

    private final Utilisateur utilisateur;

    public SessionUserDetails(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return utilisateur.getMdpUtilisateur();
    }

    @Override
    public String getUsername() {
        return utilisateur.getUtilisateurLogin();
    }
}
