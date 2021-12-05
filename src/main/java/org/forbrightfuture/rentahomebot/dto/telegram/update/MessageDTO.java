package org.forbrightfuture.rentahomebot.dto.telegram.update;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDTO {

    @JsonProperty("message_id")
    private Long messageId;

    @JsonProperty("from")
    private UserDTO from;

    @JsonProperty("chat")
    private ChatDTO chat;

    @JsonProperty("reply_to_message")
    private MessageDTO replyToMessage;

    @JsonProperty("date")
    private Long date;

    @JsonProperty("text")
    private String text;



}
