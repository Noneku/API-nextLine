package fr.ln.nextLine.Service.ServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// Classe de test pour vérifier le fonctionnement de la méthode permettant de calculer le nombre de semaines comprises entre 2 dates saisies
public class SessionServiceImplTest {

    private SessionServiceImpl sessionService;

    @BeforeEach
    public void setUp() {
        sessionService = new SessionServiceImpl(null); // null car on ne teste pas le repository ici
    }

    @Test
    public void testCalculNombreSemaines() {
        LocalDate dateDebut1 = LocalDate.of(2024, 9, 16);
        LocalDate DateFin1 = LocalDate.of(2024, 12, 6);
        int result1 = sessionService.calculNombreSemaines(dateDebut1, DateFin1);
        System.out.println("resultat test 1 : " + result1);
        assertEquals(12, result1);

        LocalDate dateDebut2 = LocalDate.of(2024, 1, 1);
        LocalDate dateFin2 = LocalDate.of(2024, 3, 15);
        int result2 = sessionService.calculNombreSemaines(dateDebut2, dateFin2);
        System.out.println("resultat test 2 : " + result2);
        assertEquals(11, result2);

        LocalDate dateDebut3 = LocalDate.of(2024, 1, 1);
        LocalDate dateFin3 = LocalDate.of(2024, 1, 1);
        int result3 = sessionService.calculNombreSemaines(dateDebut3, dateFin3);
        System.out.println("resultat test 3 : " + result3);
        assertEquals(0, result3);
    }

    @Test
    public void testCalculNombreSemainesInvalidDates() {
        // Verification de l'exception lorsque la date de début saisie est après la date de fin
        LocalDate startDate = LocalDate.of(2024, 1, 10);
        LocalDate endDate = LocalDate.of(2024, 1, 1);

        assertThrows(IllegalArgumentException.class, () -> sessionService.calculNombreSemaines(startDate, endDate));
    }

}