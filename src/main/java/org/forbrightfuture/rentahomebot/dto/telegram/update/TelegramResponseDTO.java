package org.forbrightfuture.rentahomebot.dto.telegram.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramResponseDTO {

    @JsonProperty("ok")
    private Boolean ok;

    @JsonProperty("result")
    private List<TelegramUpdateDTO> result;

    @JsonProperty("error_code")
    private Long errorCode;

    @JsonProperty("parameters")
    private ParameterDTO parameters;

}
