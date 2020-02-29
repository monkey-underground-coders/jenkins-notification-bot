package space.delusive.telegram.dto;

import lombok.Value;

@Value
public class Notification {
    private final String name;
    private final String url;
    private final Build build;
}
