package com.sanger.sprintel.dto.room;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CheckRoomsAvailablesDto {

    @NotNull
    private LocalDate start;

    @NotNull
    private LocalDate end;

    @NotNull
    private Short capacity;

}
