package fr.ln.nextLine.Service.ServiceExt;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDGeneratorService {

    public static String generateUUID(String prenom, String nom) {

        String prenomPart = prenom.toLowerCase().substring(0, 2);
        String nomPart = nom.toLowerCase().substring(0, 3);
        String uniqueID = UUID.randomUUID().toString().substring(0, 5);

        return prenomPart + nomPart + uniqueID;
    }
}
