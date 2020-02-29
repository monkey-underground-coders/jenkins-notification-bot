package space.delusive.telegram.integration.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import space.delusive.telegram.integration.TelegramIntegration;

import java.util.Map;

@Component
public class TelegramIntegrationImpl implements TelegramIntegration {
    private final RestTemplate restTemplate;
    private final String botToken;
    private final String url;

    public TelegramIntegrationImpl(RestTemplate restTemplate,
                                   @Qualifier("botToken") String botToken,
                                   @Qualifier("sendMessageUrl") String url) {
        this.restTemplate = restTemplate;
        this.botToken = botToken;
        this.url = url;
    }

    public void sendMessage(String chatId, String messageText) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .uriVariables(Map.of("botToken", botToken))
                .queryParam("chat_id", chatId)
                .queryParam("text", messageText);
        restTemplate.getForEntity(uriComponentsBuilder.build().toString(), String.class);
    }
}
