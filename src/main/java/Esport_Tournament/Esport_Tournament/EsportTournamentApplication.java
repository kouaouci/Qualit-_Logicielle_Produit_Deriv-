package Esport_Tournament.Esport_Tournament;

import Esport_Tournament.Esport_Tournament.controllers.ConsoleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories
@SpringBootApplication
@EntityScan( basePackages  = { "Esport_Tournament.Esport_Tournament" })

public class EsportTournamentApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext =SpringApplication.run(EsportTournamentApplication.class, args);
		ConsoleController consoleController = applicationContext.getBean(ConsoleController.class);
		//SpringApplication.run(EsportTournamentApplication.class, args);
		consoleController.printConsoleApp();
	}

}
