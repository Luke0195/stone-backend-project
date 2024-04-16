package br.com.starwarsproject.services.impl;

import br.com.starwarsproject.domain.Buy;
import br.com.starwarsproject.dtos.BuyDto;
import br.com.starwarsproject.dtos.HistoricDto;
import br.com.starwarsproject.mappers.BuyMapper;
import br.com.starwarsproject.mappers.HistoryMapper;
import br.com.starwarsproject.repositories.BuyRepository;
import br.com.starwarsproject.services.BuyService;
import br.com.starwarsproject.services.exceptions.TransformValueException;
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
        Buy buy = BuyMapper.INSTANCE.mapDtoToEntity(dto);
        buyRepository.save(buy);
        return BuyMapper.INSTANCE.mapEntityToDto(buy);
    }

    @Override
    @Transactional
    public List<HistoricDto> findAllHistorics() {
        return buyRepository.findAllHistoric().stream().map(BuyServiceImpl::mapResult).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoricDto> findAllHistoricsById(String id) {
        return buyRepository.findAllHistoricByClientId(id).stream().map(BuyServiceImpl::mapResult).toList();
    }

    private static HistoricDto mapResult(Object x) {
        String[] result = resultByObjectMapper(x);
        String id = String.valueOf(result[0]);
        String clientId = String.valueOf(result[1]);
        BigDecimal value = BigDecimal.valueOf(Double.parseDouble(String.valueOf(result[2])));
        String date = String.valueOf(result[3]);
        String purschaseId = String.valueOf(result[4]);
        String cardNumber = FormatterUtil.maskCreditCard(String.valueOf(result[5]));
        return HistoryMapper.makeHistoryDto(id, value, date, clientId, purschaseId, cardNumber);
    }


    private static String[] resultByObjectMapper(Object x) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(x).replace("\"", "").replace("[", "").replace("]", "");
            String[] result = json.split(",");
            return result;
        } catch (JsonProcessingException e) {
            throw new TransformValueException("Fail to convert data using objectMapper");
        }

    }
}
