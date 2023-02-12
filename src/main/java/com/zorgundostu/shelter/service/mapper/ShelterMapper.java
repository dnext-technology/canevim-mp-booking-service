package com.zorgundostu.shelter.service.mapper;

import com.zorgundostu.shelter.model.offer.Offerer;
import com.zorgundostu.shelter.model.offer.OffererCreateDto;
import com.zorgundostu.shelter.model.offer.OffererDto;
import com.zorgundostu.shelter.model.request.Requester;
import com.zorgundostu.shelter.model.request.RequesterCreateDto;
import com.zorgundostu.shelter.model.request.RequesterDto;
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
