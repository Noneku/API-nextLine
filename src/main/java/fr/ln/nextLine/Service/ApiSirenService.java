package fr.ln.nextLine.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiSirenService {

    @Value("${api.siren.key}")
    private String apiKey;

    private static final String API_URL = "https://data.siren-api.fr/v3/etablissements/";

    @Autowired
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public ApiSirenService(
            RestTemplate restTemplate,
            ObjectMapper objectMapper) {

        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String verifierEntreprise(String siret) {

        String url = API_URL + siret;

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
