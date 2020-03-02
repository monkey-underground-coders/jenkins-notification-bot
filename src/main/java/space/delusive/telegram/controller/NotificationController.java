package space.delusive.telegram.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import space.delusive.telegram.dto.Notification;
import space.delusive.telegram.exception.NotSuccessRequestException;
import space.delusive.telegram.service.TelegramService;

import java.util.Map;

@Controller
@Log4j2
public class NotificationController {
    private final TelegramService telegramService;
    private final String secret;

    public NotificationController(TelegramService telegramService,
                                  @Qualifier("secret") String secret) {
        this.telegramService = telegramService;
        this.secret = secret;
    }


    @GetMapping("/notify")
    @ResponseBody
    public Map<String, String> notify(@RequestBody Notification notification,
                                      @RequestParam String secret) {
        if (this.secret.equals(secret)) {
            telegramService.sendNotificationMessage(notification);
            return Map.of("status", "ok");
        }
        return Map.of("error", "Invalid secret provided");
    }

    @ExceptionHandler(NotSuccessRequestException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, String> handleNotSuccessRequestException(NotSuccessRequestException notSuccessRequestException) {
        log.error(notSuccessRequestException);
        return Map.of("error", "Something went wrong. Check logs.");
    }
}
