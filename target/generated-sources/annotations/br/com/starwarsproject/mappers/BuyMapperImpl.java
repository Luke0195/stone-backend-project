package br.com.starwarsproject.mappers;

import br.com.starwarsproject.domain.Buy;
import br.com.starwarsproject.domain.CreditCard;
import br.com.starwarsproject.dtos.BuyDto;
import br.com.starwarsproject.dtos.CreditCardDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-15T11:04:56-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Azul Systems, Inc.)"
)
public class BuyMapperImpl implements BuyMapper {

    @Override
    public BuyDto mapEntityToDto(Buy entity) {
        if ( entity == null ) {
            return null;
        }

        BuyDto.BuyDtoBuilder buyDto = BuyDto.builder();

        buyDto.id( entity.getId() );
        buyDto.clientId( entity.getClientId() );
        buyDto.clientName( entity.getClientName() );
        buyDto.totalToPay( entity.getTotalToPay() );
        buyDto.creditCard( creditCardToCreditCardDto( entity.getCreditCard() ) );

        return buyDto.build();
    }

    @Override
    public Buy mapDtoToEntity(BuyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Buy.BuyBuilder buy = Buy.builder();

        buy.id( dto.getId() );
        buy.clientId( dto.getClientId() );
        buy.clientName( dto.getClientName() );
        buy.creditCard( creditCardDtoToCreditCard( dto.getCreditCard() ) );
        buy.totalToPay( dto.getTotalToPay() );

        return buy.build();
    }

    protected CreditCardDto creditCardToCreditCardDto(CreditCard creditCard) {
        if ( creditCard == null ) {
            return null;
        }

        CreditCardDto.CreditCardDtoBuilder creditCardDto = CreditCardDto.builder();

        creditCardDto.cardNumber( creditCard.getCardNumber() );
        creditCardDto.value( creditCard.getValue() );
        creditCardDto.cvv( creditCard.getCvv() );
        creditCardDto.cardHolderName( creditCard.getCardHolderName() );
        creditCardDto.expDate( creditCard.getExpDate() );

        return creditCardDto.build();
    }

    protected CreditCard creditCardDtoToCreditCard(CreditCardDto creditCardDto) {
        if ( creditCardDto == null ) {
            return null;
        }

        CreditCard.CreditCardBuilder creditCard = CreditCard.builder();

        creditCard.cardNumber( creditCardDto.getCardNumber() );
        creditCard.value( creditCardDto.getValue() );
        creditCard.cvv( creditCardDto.getCvv() );
        creditCard.cardHolderName( creditCardDto.getCardHolderName() );
        creditCard.expDate( creditCardDto.getExpDate() );

        return creditCard.build();
    }
}
