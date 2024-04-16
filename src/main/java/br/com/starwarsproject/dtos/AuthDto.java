package br.com.starwarsproject.dtos;

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
public class AuthDto implements Serializable {

    @NotEmpty(message = "The field e-mail must be required")
    @Email(message="The field e-mail is required")
    private String email;
    @NotEmpty(message = "The field password must be required")
    private String password;
}
