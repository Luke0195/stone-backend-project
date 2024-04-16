package br.com.starwarsproject.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardDto implements Serializable {

    @NotEmpty(message = "The cardNumber must be required")
    @JsonProperty("card_number")
    private String cardNumber;

    @Size(min=1)
    @NotNull
    private BigDecimal value;

    @Size(min=3, max = 3, message = "Please provided a valid cvv example: 123")
    @NotNull
    private Integer cvv;

    @NotEmpty(message="The field card_holder_name must be required")
    @JsonProperty("card_holder_name")
    private String cardHolderName;

    @JsonProperty("exp_date")
    @JsonFormat(pattern = "dd/mm")
    @NotEmpty(message = "The field exp_date must be required")
    private String expDate;
}
