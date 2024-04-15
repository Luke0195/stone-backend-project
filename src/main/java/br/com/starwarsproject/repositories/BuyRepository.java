package br.com.starwarsproject.repositories;

import br.com.starwarsproject.domain.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<Buy, String> {
}
