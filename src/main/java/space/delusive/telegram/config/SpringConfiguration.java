package space.delusive.telegram.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebMvcConfiguration.class)
public class SpringConfiguration {
}
