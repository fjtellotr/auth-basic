package pe.idat.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.stereotype.Component;
import pe.idat.security.model.User;
import pe.idat.security.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        if(userService.findAll().isEmpty()){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setRole("ADMIN");
            admin.setEnabled(true);
            userService.save(admin);


            User user = new User();
            user.setUsername("user");
            user.setPassword("user123");
            user.setRole("USER");
            user.setEnabled(true);
            userService.save(user);

        }
    }
}
