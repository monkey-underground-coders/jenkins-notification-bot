package space.delusive.telegram.integration.impl;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import space.delusive.telegram.exception.NotSuccessRequestException;
import space.delusive.telegram.integration.TelegramIntegration;

@Component
public class TelegramIntegrationImpl implements TelegramIntegration {
    private final String botToken;
    private final String url;

    public TelegramIntegrationImpl(@Qualifier("botToken") String botToken,
                                   @Qualifier("sendMessageUrl") String url) {
        this.botToken = botToken;
        this.url = url;
    }

    public void sendMessage(String chatId, String messageText) throws NotSuccessRequestException {
        HttpResponse<String> httpResponse = Unirest.get(url)
                .routeParam("botToken", botToken)
                .queryString("chat_id", chatId)
                .queryString("text", messageText)
                .asString();
        httpResponse.ifFailure(response -> {
            throw new NotSuccessRequestException(response.toString());
        });
    }
}
