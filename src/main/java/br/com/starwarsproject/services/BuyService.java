package br.com.starwarsproject.services;

import br.com.starwarsproject.dtos.BuyDto;
import br.com.starwarsproject.dtos.HistoricDto;


import java.util.List;


public interface BuyService {

     BuyDto create(BuyDto dto);
     List<HistoricDto> findAllHistorics();
     List<HistoricDto> findAllHistoricsById(String id);
}
