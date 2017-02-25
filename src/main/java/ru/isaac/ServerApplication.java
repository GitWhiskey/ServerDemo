package ru.isaac;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import ru.isaac.model.User;
import ru.isaac.model.UserRepository;
import ru.isaac.security.SecurityConfiguration;

import java.time.LocalDate;

@SpringBootApplication
@Import({SecurityConfiguration.class, WebConfiguration.class})
public class ServerApplication {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	public InitializingBean initializeUsers() {
		return () -> {
			User u1 = new User("Max K", "maxk", "pass1", LocalDate.of(1994, 12, 11));
			User u2 = new User("Zhenya S", "zhenyas", "pass2", LocalDate.of(1995, 7, 29));
			User u3 = new User("Misha Y", "mishay", "pass3", LocalDate.of(1994, 3, 22));

            repository.addUser(u1);
            repository.addUser(u2);
            repository.addUser(u3);
		};
	}
}
