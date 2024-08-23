package fr.ln.nextLine.config.Security.Filter;

import fr.ln.nextLine.config.Security.AuthUserDetailsService;
import fr.ln.nextLine.config.Security.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final AuthUserDetailsService authUserDetailsService;

    public JwtRequestFilter(JwtUtil jwtUtil, AuthUserDetailsService authUserDetailsService) {
        this.jwtUtil = jwtUtil;
        this.authUserDetailsService = authUserDetailsService;
    }

    @Override
    protected void doFilterInternal(@org.jetbrains.annotations.NotNull HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        // Vérifie si l'en-tête Authorization est présent et commence par "Bearer"
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtUtil.getUsernameFromToken(jwtToken);
            System.out.println("Token reçu : " + jwtToken);
            System.out.println("Nom d'utilisateur extrait : " + username);
        }

        // Vérifie si le nom d'utilisateur est non nul et s'il n'y a pas déjà une authentification dans le contexte de sécurité
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtUtil.validateToken(jwtToken)) {
                UserDetails userDetails = authUserDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("Authentification réussie pour : " + username);
            } else {
                System.out.println("Token invalide");
            }
        }
        // Passe la requête et la réponse au prochain filtre dans la chaîne de filtres
        filterChain.doFilter(request, response);
    }
}
