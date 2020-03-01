package space.delusive.telegram.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import space.delusive.telegram.dto.Build;
import space.delusive.telegram.dto.Notification;
import space.delusive.telegram.integration.TelegramIntegration;
import space.delusive.telegram.service.TelegramService;

@Component
public class TelegramServiceImpl implements TelegramService {
    private final TelegramIntegration telegramIntegration;
    private final String messagePattern;
    private final String chatId;

    public TelegramServiceImpl(TelegramIntegration telegramIntegration,
                               @Qualifier("messagePattern") String messagePattern,
                               @Qualifier("targetChatId") String chatId) {
        this.telegramIntegration = telegramIntegration;
        this.messagePattern = messagePattern;
        this.chatId = chatId;
    }

    public void sendNotificationMessage(Notification notification) {
        Build build = notification.getBuild();
        telegramIntegration.sendMessage(chatId, messagePattern.replaceAll("%job%", notification.getName())
                .replaceAll("%phase%", build.getPhase())
                .replaceAll("%status%", build.getStatus())
                .replaceAll("%full_link%", build.getFullUrl())
                .replaceAll("%number%", String.valueOf(build.getNumber())));
    }
}
