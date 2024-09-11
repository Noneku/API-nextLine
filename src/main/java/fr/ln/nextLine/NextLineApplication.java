package fr.ln.nextLine;

import fr.ln.nextLine.Model.Dto.RoleDTO;
import fr.ln.nextLine.Model.Dto.UtilisateurDTO;
import fr.ln.nextLine.Model.Entity.Utilisateur;
import fr.ln.nextLine.Model.Mapper.UtilisateurMapper;
import fr.ln.nextLine.Model.Repository.UtilisateurRepository;
import fr.ln.nextLine.Service.ServiceExt.PasswordGeneratorService;
import fr.ln.nextLine.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

import static fr.ln.nextLine.config.Security.SecurityConfig.passwordEncoder;

@SpringBootApplication
public class NextLineApplication implements CommandLineRunner {

	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	private UtilisateurMapper utilisateurMapper;

	public static void main(String[] args) {

		SpringApplication.run(NextLineApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		RoleDTO roleDTO = new RoleDTO(1, "ADMIN");
		utilisateurDTO.setNomUtilisateur("Gacem");
		utilisateurDTO.setPrenomUtilisateur("Nassim");
		utilisateurDTO.setEmailUtilisateur("admin@example.com");
		utilisateurDTO.setMdpUtilisateur("password123");
		utilisateurDTO.setMdpUtilisateur(passwordEncoder().encode(utilisateurDTO.getMdpUtilisateur()));
		utilisateurDTO.setUtilisateurLogin("admin");
		utilisateurDTO.setIsactive(false);
		utilisateurDTO.setRoleDTO(roleDTO);
		utilisateurDTO.setDateCreation(LocalDate.now());

		utilisateurRepository.save(utilisateurMapper.toEntity(utilisateurDTO));

		UtilisateurDTO stagiaire = new UtilisateurDTO();
		RoleDTO roleDTOStagiaire = new RoleDTO( 2, "STAGIAIRE");
		stagiaire.setNomUtilisateur("Delahaie");
		stagiaire.setPrenomUtilisateur("Phillipe");
		stagiaire.setUtilisateurLogin("stagiaire");
		stagiaire.setEmailUtilisateur("stagiaire@example.com");
		stagiaire.setMdpUtilisateur("password123");
		stagiaire.setMdpUtilisateur(passwordEncoder().encode(stagiaire.getMdpUtilisateur()));
		stagiaire.setIsactive(false);
		stagiaire.setRoleDTO(roleDTOStagiaire);
		stagiaire.setDateCreation(LocalDate.now());

		utilisateurRepository.save(utilisateurMapper.toEntity(stagiaire));


		UtilisateurDTO formateur = new UtilisateurDTO();
		RoleDTO roleDTOFormateur = new RoleDTO(3, "FORMATEUR");
		formateur.setNomUtilisateur("Ronom");
		formateur.setPrenomUtilisateur("Edouard");
		formateur.setEmailUtilisateur("leila.mouaci@gmail.com");
		formateur.setMdpUtilisateur("password123");
		formateur.setMdpUtilisateur(passwordEncoder().encode(formateur.getMdpUtilisateur()));
		formateur.setUtilisateurLogin("formateur");
		formateur.setIsactive(false);
		formateur.setRoleDTO(roleDTOFormateur);
		formateur.setDateCreation(LocalDate.now());

		// Appel de la méthode create() pour créer l'utilisateur

		utilisateurRepository.save(utilisateurMapper.toEntity(formateur));

		System.out.println("Utilisateur créé au démarrage de l'application !");
	}
}
