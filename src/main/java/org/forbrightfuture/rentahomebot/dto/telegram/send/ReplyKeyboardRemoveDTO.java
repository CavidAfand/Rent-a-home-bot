package org.forbrightfuture.rentahomebot.dto.telegram.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyKeyboardRemoveDTO implements ReplyKeyboard {

    @JsonProperty("remove_keyboard")
    private Boolean removeKeyboard;

}
