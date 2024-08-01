package fr.ln.nextLine.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


// service permettant de faire un appel a l'api siren avec une méthode permettant de rechercher en saisissant le numéro siret de l'entreprise

@Service
public class ApiSirenService {

    @Value("${api.siren.key}")
    private String apiKey;

    private static final String API_URL = "https://data.siren-api.fr/v3/etablissements/";

    @Autowired
    private RestTemplate restTemplate;

    public ApiSirenService(
            RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public String verifierEntreprise(String siret) {

        String url = API_URL + siret;

        // paramètres à passer dans le header de la requête avec la clé de l'api et le formatage du retour en JSON
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Client-Secret", apiKey);
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {

            return response.getBody();

        } else {

            throw new RuntimeException("Erreur lors de l'appel à l'API Siren: " + response.getStatusCode());
        }
    }
}
