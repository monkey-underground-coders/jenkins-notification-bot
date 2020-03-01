package space.delusive.telegram.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class Build {
    @SerializedName("full_url")
    private final String fullUrl;
    private final int number;
    private final String phase;
    private final String status;
    private final String url;
}
