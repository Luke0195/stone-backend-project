package br.com.starwarsproject.services.impl;

import br.com.starwarsproject.domain.Buy;
import br.com.starwarsproject.dtos.BuyDto;
import br.com.starwarsproject.dtos.HistoricDto;
import br.com.starwarsproject.mappers.BuyMapper;
import br.com.starwarsproject.repositories.BuyRepository;
import br.com.starwarsproject.services.BuyService;
import br.com.starwarsproject.utils.FormatterUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;


@Service
@AllArgsConstructor
public class BuyServiceImpl implements BuyService {

    private final BuyRepository buyRepository;

    @Override
    @Transactional
    public BuyDto create(BuyDto dto) {
        Buy buy  = BuyMapper.INSTANCE.mapDtoToEntity(dto);
        buyRepository.save(buy);
        return  BuyMapper.INSTANCE.mapEntityToDto(buy);
    }

    @Override
    @Transactional
    public List<HistoricDto> findAllHistorics() {
        try{
            return buyRepository.findAllHistoric().stream().map(BuyServiceImpl::mapResult).toList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static HistoricDto mapResult(Object x){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(x).replaceAll("\"", "").replace("[", "").replace("]", "");
            String[] result =  json.split(",");
            String id = String.valueOf(result[0]);
            String clientId = String.valueOf(result[1]);
            String value = String.valueOf(result[2]);
            String date=  String.valueOf(result[3]);
            String purschaseId = String.valueOf(result[4]);
            String cardNumber = String.valueOf(result[5]);
            return HistoricDto.builder()
                    .id(id)
                    .clientId(clientId)
                    .value(BigDecimal.valueOf(Double.parseDouble(value)))
                    .date(date)
                    .purchaseId(purschaseId)
                    .cardNumber(FormatterUtil.maskCreditCard(cardNumber))
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
