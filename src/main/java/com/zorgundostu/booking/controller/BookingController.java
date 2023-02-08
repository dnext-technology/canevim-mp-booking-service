package com.zorgundostu.booking.controller;

import java.util.Map;

import com.zorgundostu.booking.model.offer.OffererCreateDto;
import com.zorgundostu.booking.model.request.RequesterCreateDto;
import com.zorgundostu.booking.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookingController implements BookingApi{

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @Override
    public ResponseEntity<Object> createRequester(Map<String, String> header, RequesterCreateDto requesterCreateDto) {
        return ResponseEntity.ok(bookingService.createRequester(requesterCreateDto));
    }

    @Override
    public ResponseEntity<Object> getAllRequesters(Map<String, String> header, int page, int size) {
        return ResponseEntity.ok(bookingService.getAllActiveRequesters(page, size));
    }

    @Override
    public ResponseEntity<Object> createOfferer(Map<String, String> header, OffererCreateDto offererCreateDto) {
        return ResponseEntity.ok(bookingService.createOfferer(offererCreateDto));
    }

    @Override
    public ResponseEntity<Object> getAllOfferers(Map<String, String> header, int page, int size) {
        return ResponseEntity.ok(bookingService.getAllActiveOfferers(page, size));
    }

    @Override
    public ResponseEntity<Object> getStatistics(Map<String, String> header) {
        return ResponseEntity.ok(bookingService.getStatistics());
    }
}
