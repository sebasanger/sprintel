package com.sanger.sprintel.dto.auth;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidateUserTokenDto {
    @NotBlank(message = "El token no puede estar vacio")
    private String token;

}
