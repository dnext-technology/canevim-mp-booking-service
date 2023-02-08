package com.zorgundostu.booking.service.mapper;

import com.zorgundostu.booking.model.offer.Offerer;
import com.zorgundostu.booking.model.offer.OffererCreateDto;
import com.zorgundostu.booking.model.offer.OffererDto;
import com.zorgundostu.booking.model.request.Requester;
import com.zorgundostu.booking.model.request.RequesterCreateDto;
import com.zorgundostu.booking.model.request.RequesterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BookingMapper {
    Requester toDao(RequesterCreateDto requesterCreateDto);
    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "dd.MM.yyyy")
    RequesterDto toDto(Requester requester);

    Offerer toDao(OffererCreateDto offererCreateDto);
    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "dd.MM.yyyy")
    OffererDto toDto(Offerer offerer);
}
