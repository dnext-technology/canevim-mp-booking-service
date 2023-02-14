package com.canevim.shelter.controller;

import java.util.Map;

import com.canevim.shelter.constant.ShelterTypes;
import com.canevim.shelter.constant.StatusTypes;
import com.canevim.shelter.model.offer.OffererCreateDto;
import com.canevim.shelter.model.request.RequesterCreateDto;
import com.canevim.shelter.service.ShelterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class ShelterController implements ShelterApi {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @Override
    public ResponseEntity<Object> createRequester(Map<String, String> header, RequesterCreateDto requesterCreateDto) {
        return ResponseEntity.ok(shelterService.createRequester(requesterCreateDto));
    }

    @Override
    public ResponseEntity<Object> getAllRequesters(Map<String, String> header, int page, int size) {
        return ResponseEntity.ok(shelterService.getAllActiveRequesters(page, size));
    }

    @Override
    public ResponseEntity<Object> createOfferer(Map<String, String> header, OffererCreateDto offererCreateDto) {
        return ResponseEntity.ok(shelterService.createOfferer(header, offererCreateDto));
    }

    @Override
    public ResponseEntity<Object> getAllOfferers(Map<String, String> header, int page, int size) {
        return ResponseEntity.ok(shelterService.getAllActiveOfferers(page, size));
    }

    @Override
    public ResponseEntity<Object> getStatistics(Map<String, String> header) {
        return ResponseEntity.ok(shelterService.getStatistics());
    }

    @Override
    public ResponseEntity<Object> updateStatus(Map<String, String> header, ShelterTypes shelterType, StatusTypes statusType, String id) {
        return ResponseEntity.ok(shelterService.updateStatus(shelterType, statusType, id));
    }


}
