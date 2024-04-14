package br.com.starwarsproject.repositories;

import br.com.starwarsproject.domain.Product;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    @Query(value="SELECT p FROM Product as p where p.title =:title")
    Optional<Product> findByTitle(String title);


    @Query(value="SELECT p FROM Product as p where p.zipcode =:zipcode")
    Optional<Product> findByZipcode(String zipcode);
}
