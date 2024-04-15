package br.com.starwarsproject.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.*;
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
public class BuyDto implements Serializable {
    private String id;

    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("client_name")
    private String clientName;
    @JsonProperty("total_to_pay")
    @Min(1)
    private BigDecimal totalToPay;

    @JsonProperty("credit_card")
    private CreditCardDto creditCard;


}
