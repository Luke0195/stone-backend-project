package br.com.starwarsproject.dtos;

import br.com.starwarsproject.domain.enums.AuthRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto implements Serializable {

    private String id;
    @NotEmpty(message = "The field name is required")
    private String name;
    @NotEmpty(message="The field email is required")
    @Email(message="Please provided a valid email")
    private String email;
    @NotEmpty(message="The field password is required")
    private String password;
    private AuthRole role;
}
