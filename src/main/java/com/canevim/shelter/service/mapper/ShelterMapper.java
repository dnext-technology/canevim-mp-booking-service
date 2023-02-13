package com.canevim.shelter.service.mapper;

import com.canevim.shelter.model.offer.Offerer;
import com.canevim.shelter.model.offer.OffererCreateDto;
import com.canevim.shelter.model.offer.OffererDto;
import com.canevim.shelter.model.request.Requester;
import com.canevim.shelter.model.request.RequesterCreateDto;
import com.canevim.shelter.model.request.RequesterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ShelterMapper {
    Requester toDao(RequesterCreateDto requesterCreateDto);
    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "dd.MM.yyyy")
    RequesterDto toDto(Requester requester);

    Offerer toDao(OffererCreateDto offererCreateDto);
    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "dd.MM.yyyy")
    OffererDto toDto(Offerer offerer);
}
