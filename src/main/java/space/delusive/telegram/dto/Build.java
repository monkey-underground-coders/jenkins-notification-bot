package space.delusive.telegram.dto;

import lombok.Value;

@Value
public class Build {
    private final String fullUrl;
    private final int number;
    private final String phase;
    private final String statue;
    private final String url;
}
