package org.forbrightfuture.rentahomebot.dto.telegram.send.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SendPhotoDTO {

    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("caption")
    private String caption;

    @JsonProperty("parse_mode")
    private String parseMode;

}
