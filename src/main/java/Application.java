import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@EnableAutoConfiguration
@EnableSpringConfigured
@SpringBootApplication
@ComponentScan("configuration")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
