package br.com.starwarsproject.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto implements Serializable {

    private String id;

    @NotEmpty(message = "The field title must be required")
    private String title;

    @Min(1)
    @NotNull(message = "The field price must be required")
    private BigDecimal price;

    @NotEmpty(message = "The field zipcode must be required")
    private String zipcode;

    @NotEmpty(message= "The field sellet must be required")
    private String seller;

    @NotEmpty(message="The thumbnail must be required")
    private String thumbnailHd;

    @NotEmpty(message = "The field data must be required")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String date;

}
