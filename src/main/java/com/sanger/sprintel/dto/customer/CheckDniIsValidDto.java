package com.sanger.sprintel.dto.customer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CheckDniIsValidDto {

    @NotNull
    private Long id;
    @NotBlank
    private String dni;

}
