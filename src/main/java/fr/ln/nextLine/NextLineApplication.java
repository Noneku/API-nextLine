package fr.ln.nextLine;

import fr.ln.nextLine.Service.EmailSenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class NextLineApplication {

	private final EmailSenderService emailSenderService;

	public NextLineApplication(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	public static void main(String[] args) {

		SpringApplication.run(NextLineApplication.class, args);
	}


}
