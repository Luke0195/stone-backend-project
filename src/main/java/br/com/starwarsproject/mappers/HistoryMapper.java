package br.com.starwarsproject.mappers;

import br.com.starwarsproject.dtos.HistoricDto;

import java.math.BigDecimal;

public class HistoryMapper {

    private HistoryMapper(){};


    public static HistoricDto makeHistoryDto(String id, BigDecimal value, String date, String clientId,
                                             String purchaseId, String cardNumber){
        return HistoricDto.builder()
                .id(id)
                .value(value)
                .date(date)
                .clientId(clientId)
                .purchaseId(purchaseId)
                .cardNumber(cardNumber)
                .build();
    }
}
