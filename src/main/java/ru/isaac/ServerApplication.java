package ru.isaac;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import ru.isaac.dao.UserDAO;
import ru.isaac.model.User;
import ru.isaac.model.UserRepository;
import ru.isaac.security.SecurityConfiguration;

import java.time.LocalDate;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@Import({SecurityConfiguration.class, WebConfiguration.class, DataBaseConfiguration.class})
public class ServerApplication {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserDAO userDAO;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    @Profile("filling")
    public InitializingBean initializeUsers() {
        return () -> {
            User u1 = new User();
            u1.setName("Max K");
            u1.setUsername("maxk");
            u1.setPassword("pass1");
            u1.setBirthday(LocalDate.of(1994, 12, 11));

            User u2 = new User();
            u2.setName("Zhenya S");
            u2.setUsername("zhenyas");
            u2.setPassword("pass2");
            u2.setBirthday(LocalDate.of(1995, 7, 29));

            User u3 = new User();
            u3.setName("Misha Y");
            u3.setUsername("mishay");
            u3.setPassword("pass3");
            u3.setBirthday(LocalDate.of(1994, 3, 22));

//            repository.addUser(u1);
//            repository.addUser(u2);
//            repository.addUser(u3);

            userDAO.addUser(u1);
            userDAO.addUser(u2);
            userDAO.addUser(u3);
            System.out.println(userDAO.listUsers());
        };
    }
}
