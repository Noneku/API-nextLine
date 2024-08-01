package fr.ln.nextLine.config.Security;

/*
    La classe LoginRequest encapsule les informations nécessaires pour effectuer une connexion, à savoir le login et le mot de passe. Cela permet de regrouper ces données dans une seule unité,
    facilitant leur passage entre différentes couches de l'application.
 */
public record LoginRequest(String login, String password) {
}
