package fr.ln.nextLine.config.Security;

import fr.ln.nextLine.Model.Entity.Utilisateur;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

        @Getter
        private final Utilisateur utilisateur;
        private final Logger logger = LoggerFactory.getLogger(getClass());

        public CustomUserDetails(Utilisateur utilisateur) {
            this.utilisateur = utilisateur;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Collection<? extends GrantedAuthority> authorities = Collections.singletonList(
                    new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().getNomRole()));

            authorities.forEach(auth -> logger.info("Authority: " + auth.getAuthority()));
            return authorities;
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
