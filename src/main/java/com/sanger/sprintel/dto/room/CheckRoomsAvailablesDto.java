package com.sanger.sprintel.dto.room;

import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CheckRoomsAvailablesDto {

    @NotNull
    private Date start;

    @NotNull
    private Date end;

    @NotNull
    private Short capacity;

}
