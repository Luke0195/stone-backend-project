package br.com.starwarsproject.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class HistoricDto implements Serializable {

    private String id;
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("purchase_id")
    private String purchaseId;
    private BigDecimal value;
    private String date;
    @JsonProperty("card_number")
    private String cardNumber;


}
