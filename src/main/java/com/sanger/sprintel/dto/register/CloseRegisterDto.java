package com.sanger.sprintel.dto.register;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CloseRegisterDto {

    @NotNull
    private Long id;

    @NotNull
    private Double closeMount;

}
