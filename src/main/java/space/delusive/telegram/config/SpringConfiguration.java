package space.delusive.telegram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import(WebMvcConfiguration.class)
@PropertySource("classpath:application.properties")
@ComponentScan("space.delusive.telegram")
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
