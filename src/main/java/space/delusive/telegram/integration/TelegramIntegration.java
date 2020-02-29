package space.delusive.telegram.integration;

public interface TelegramIntegration {
    void sendMessage(String chatId, String messageText);
}
