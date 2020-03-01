package space.delusive.telegram.service;

import space.delusive.telegram.dto.Notification;

public interface TelegramService {
    void sendNotificationMessage(Notification notification);
}
