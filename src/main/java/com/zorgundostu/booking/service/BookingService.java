package com.zorgundostu.booking.service;

import static com.zorgundostu.booking.util.BookingUtils.generateBookingCode;

import java.util.List;

import com.zorgundostu.booking.constant.StatusTypes;
import com.zorgundostu.booking.model.offer.OffererCreateDto;
import com.zorgundostu.booking.model.offer.OffererDto;
import com.zorgundostu.booking.model.request.RequesterCreateDto;
import com.zorgundostu.booking.model.request.RequesterDto;
import com.zorgundostu.booking.model.statistics.StatisticDto;
import com.zorgundostu.booking.repository.OffererRepository;
import com.zorgundostu.booking.repository.RequesterRepository;
import com.zorgundostu.booking.service.mapper.BookingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@Transactional
public class BookingService {

    private BookingMapper bookingMapper;
    private final RequesterRepository requesterRepository;
    private final OffererRepository offererRepository;

    public BookingService(BookingMapper bookingMapper, RequesterRepository requesterRepository, OffererRepository offererRepository){
        this.bookingMapper = bookingMapper;
        this.requesterRepository = requesterRepository;
        this.offererRepository = offererRepository;
    }

    public RequesterDto createRequester(RequesterCreateDto requesterCreateDto){
        var requester = bookingMapper.toDao(requesterCreateDto);
        requester.setStatus(StatusTypes.ACTIVE.status());
        requester.setCode(generateBookingCode(requester.getFirstName(), requester.getLastName(), "R"));
        var savedRequester = requesterRepository.save(requester);
        return bookingMapper.toDto(savedRequester);
    }

    public Page<RequesterDto> getAllActiveRequesters(int page, int size){
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdDate");
        return requesterRepository.findAll(pageable).map(bookingMapper::toDto);
    }

    public OffererDto createOfferer(OffererCreateDto offererCreateDto){
        var offerer = bookingMapper.toDao(offererCreateDto);
        offerer.setStatus(StatusTypes.ACTIVE.status());
        offerer.setCode(generateBookingCode(offerer.getFirstName(), offerer.getLastName(), "O"));
        var savedOfferer = offererRepository.save(offerer);
        return bookingMapper.toDto(savedOfferer);
    }

    public Page<OffererDto> getAllActiveOfferers(int page, int size){
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdDate");
        return offererRepository.findAll(pageable).map(bookingMapper::toDto);
    }

    public List<StatisticDto> getStatistics(){
        var offererStatistic = offererRepository.findOffererStatistics();
        var requesterStatistics = requesterRepository.findRequesterStatistics();
        return List.of(offererStatistic, requesterStatistics);
    }

}
