package space.delusive.telegram.integration;

import space.delusive.telegram.exception.NotSuccessRequestException;

public interface TelegramIntegration {
    void sendMessage(String chatId, String messageText) throws NotSuccessRequestException;
}
