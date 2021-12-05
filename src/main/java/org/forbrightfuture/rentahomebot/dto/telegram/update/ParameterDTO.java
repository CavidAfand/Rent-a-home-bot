package org.forbrightfuture.rentahomebot.dto.telegram.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ParameterDTO {

    @JsonProperty("migrate_to_chat_id")
    private Long migratedChatId;

    @JsonProperty("retry_after")
    private Long retryAfter;

}
