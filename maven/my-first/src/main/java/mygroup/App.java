package mygroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot Application demonstrating the use of mygroup starter.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        
        // Get the MygroupService bean from the context
        MygroupService service = context.getBean(MygroupService.class);
        
        // Use the service
        service.sayGreeting();
    }
}
