package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ComponentScan(basePackages = {"graphql", "bl", "domain", "mappers"})
public class AppConfig {
}
