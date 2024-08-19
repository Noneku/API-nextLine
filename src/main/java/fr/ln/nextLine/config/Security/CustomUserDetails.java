package fr.ln.nextLine.config.Security;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final Utilisateur utilisateur;

    public CustomUserDetails(Utilisateur utilisateur) {
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
