package fr.ln.nextLine;

import fr.ln.nextLine.Model.Dto.RoleDTO;
import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class NextLineApplication implements CommandLineRunner {

	@Autowired
	private UtilisateurService utilisateurService;

	public static void main(String[] args) {

		SpringApplication.run(NextLineApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		// Créer un utilisateur de test pour l'exemple
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		RoleDTO roleDTO = new RoleDTO(1, "ADMIN");
		utilisateurDTO.setNomUtilisateur("Gacem");
		utilisateurDTO.setPrenomUtilisateur("Nassim");
		utilisateurDTO.setEmailUtilisateur("admin@example.com");
		utilisateurDTO.setMdpUtilisateur("password123");
		utilisateurDTO.setRoleDTO(roleDTO);
		utilisateurDTO.setDateCreation(LocalDate.now());

		// Appel de la méthode create() pour créer l'utilisateur
		utilisateurService.create(utilisateurDTO);

		System.out.println("Utilisateur créé au démarrage de l'application !");
	}
}
