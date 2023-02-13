package com.canevim.shelter.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.canevim.shelter.constant.AccommodationTypes;
import com.canevim.shelter.constant.ShelterTypes;
import com.canevim.shelter.constant.StatusTypes;
import com.canevim.shelter.repository.OffererRepository;
import com.canevim.shelter.repository.RequesterRepository;
import com.canevim.shelter.service.mapper.ShelterMapper;
import com.canevim.shelter.service.util.ShelterUtils;
import com.canevim.shelter.model.offer.OffererCreateDto;
import com.canevim.shelter.model.offer.OffererDto;
import com.canevim.shelter.model.request.RequesterCreateDto;
import com.canevim.shelter.model.request.RequesterDto;
import com.canevim.shelter.model.statistics.StatisticDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@Transactional
public class ShelterService {

    private AsyncTaskService asyncTaskService;
    private ShelterMapper shelterMapper;
    private final RequesterRepository requesterRepository;
    private final OffererRepository offererRepository;

    public ShelterService(AsyncTaskService asyncTaskService, ShelterMapper shelterMapper, RequesterRepository requesterRepository, OffererRepository offererRepository) {
        this.asyncTaskService = asyncTaskService;
        this.shelterMapper = shelterMapper;
        this.requesterRepository = requesterRepository;
        this.offererRepository = offererRepository;
    }

    public RequesterDto createRequester(RequesterCreateDto requesterCreateDto) {
        var requester = shelterMapper.toDao(requesterCreateDto);
        requester.setStatus(StatusTypes.ACTIVE.status());
        requester.setCode(ShelterUtils.generateShelterCode(requester.getFirstName(), requester.getLastName(), "R"));
        var savedRequester = requesterRepository.save(requester);
        return shelterMapper.toDto(savedRequester);
    }

    public Page<RequesterDto> getAllActiveRequesters(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdDate");
        return requesterRepository.findAll(pageable).map(shelterMapper::toDto);
    }

    public OffererDto createOfferer(Map<String, String> header, OffererCreateDto offererCreateDto) {
        var offerer = shelterMapper.toDao(offererCreateDto);
        offerer.setStatus(StatusTypes.ACTIVE.status());
        offerer.setCode(ShelterUtils.generateShelterCode(offerer.getFirstName(), offerer.getLastName(), "O"));
        var savedOfferer = offererRepository.save(offerer);
        var offerDto = shelterMapper.toDto(savedOfferer);

        if (AccommodationTypes.APARTMENT.accommodation().equalsIgnoreCase(savedOfferer.getAccommodationType()) || AccommodationTypes.DETACHED_HOUSE.accommodation().equalsIgnoreCase(savedOfferer.getAccommodationType())) {
            asyncTaskService.callForNotifyingMinistry(savedOfferer);
        }

        asyncTaskService.sendNotification(savedOfferer.getFirstName(), savedOfferer.getLastName(), savedOfferer.getPhone(), savedOfferer.getCode());
        return offerDto;
    }

    public Page<OffererDto> getAllActiveOfferers(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdDate");
        return offererRepository.findAll(pageable).map(shelterMapper::toDto);
    }

    public List<StatisticDto> getStatistics() {
        var offererStatistic = offererRepository.findOffererStatistics();
        var requesterStatistics = new StatisticDto("123",1,2); //requesterRepository.findRequesterStatistics();
        return List.of(offererStatistic, requesterStatistics);
    }

    public boolean updateStatus(ShelterTypes shelterType, StatusTypes statusType, String id) {
        if (shelterType.equals(ShelterTypes.REQUESTERS)) {
//            requesterRepository.updateStatus(UUID.fromString(id), statusType.status());
        } else {
            offererRepository.updateStatus(UUID.fromString(id), statusType.status());
        }
        return true;
    }

}
