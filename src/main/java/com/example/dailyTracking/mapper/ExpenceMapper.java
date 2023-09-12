package com.example.dailyTracking.mapper;

import com.example.dailyTracking.dto.ExpenceDto;
import com.example.dailyTracking.model.Expence;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExpenceMapper {

    /**
     * This method is used map ExpenceDTO object into Expence object
     * @param expenceDto
     * @return
     */
    Expence toExpence(ExpenceDto expenceDto);

    /**
     * This method is used map Expence List into ExpenceDTO List
     * @param expences
     * @return
     */
    List<ExpenceDto> toEXPENCEDTOLIST(List<Expence> expences);


}
