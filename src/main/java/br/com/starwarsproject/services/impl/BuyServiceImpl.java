package br.com.starwarsproject.services.impl;

import br.com.starwarsproject.domain.Buy;
import br.com.starwarsproject.dtos.BuyDto;
import br.com.starwarsproject.mappers.BuyMapper;
import br.com.starwarsproject.repositories.BuyRepository;
import br.com.starwarsproject.services.BuyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BuyServiceImpl implements BuyService {

    private final BuyRepository buyRepository;


    @Override
    @Transactional
    public BuyDto create(BuyDto dto) {
        Buy buy  = BuyMapper.INSTANCE.mapDtoToEntity(dto);
         buyRepository.save(buy);
        return BuyMapper.INSTANCE.mapEntityToDto(buy);
    }
}
