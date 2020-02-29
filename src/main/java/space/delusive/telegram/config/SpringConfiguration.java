package space.delusive.telegram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import(WebMvcConfiguration.class)
@PropertySource("classpath:application.properties")
public class SpringConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public String sendMessageUrl(@Value("${bot.url.send.message}") String sendMessageUrl) {
        return sendMessageUrl;
    }

    @Bean
    public String botToken(@Value("${bot.token}") String botToken) {
        return botToken;
    }
}
