package br.com.starwarsproject.repositories;

import br.com.starwarsproject.domain.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuyRepository extends JpaRepository<Buy, String> {

    @Query(value = "SELECT b.id, b.clientId as client_id, b.totalToPay as value, b.date, cc.id, cc.cardNumber FROM Buy as b  JOIN CreditCard  as cc on b.creditCard.id = cc.id")
    List<?> findAllHistoric();

    @Query(value = "SELECT b.id, b.clientId as client_id, b.totalToPay as value, b.date, cc.id, cc.cardNumber FROM Buy as b  JOIN CreditCard  as cc on b.clientId =:id")
    List<?> findAllHistoricByClientId(String id);
}
