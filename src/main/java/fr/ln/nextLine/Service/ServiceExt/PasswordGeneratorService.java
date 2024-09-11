package fr.ln.nextLine.Service.ServiceExt;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class PasswordGeneratorService {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+<>?";

    private static final String ALL_CHARS = UPPER + LOWER + DIGITS + SPECIAL;

    public static String generatePassword() {
        int length = 5;
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        // Générer exactement 5 caractères aléatoires
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL_CHARS.length());
            password.append(ALL_CHARS.charAt(index));
        }

        return password.toString();
    }
}
