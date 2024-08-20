package fr.ln.nextLine.config.Security;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

        private final Utilisateur utilisateur;

        public CustomUserDetails(Utilisateur utilisateur) {
            this.utilisateur = utilisateur;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singletonList(new SimpleGrantedAuthority(utilisateur.getRole().getNomRole()));
        }

        @Override
        public String getPassword() {
            return utilisateur.getMdpUtilisateur();
        }

        @Override
        public String getUsername() {
            return utilisateur.getUtilisateurLogin();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
}
