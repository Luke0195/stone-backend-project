package br.com.starwarsproject.domain;

import jakarta.persistence.*;
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
@Entity
@Table(name="tb_credit_cards")
public class CreditCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="card_number", nullable = false)
    private String cardNumber;
    @Column(nullable = false)
    private BigDecimal value;
    @Column(nullable = false)
    private Integer cvv;
    @Column(name="card_holder_name", nullable = false)
    private String cardHolderName;
    @Column(nullable = false)
    private String expDate;

    @OneToOne(mappedBy = "creditCard")
    private Buy buy;

}
