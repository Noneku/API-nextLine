package fr.ln.nextLine.Service.ServiceExt;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDGeneratorService {

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
