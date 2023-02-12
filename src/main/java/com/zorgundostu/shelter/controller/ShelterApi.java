package com.zorgundostu.shelter.controller;

import java.util.Map;

import com.zorgundostu.shelter.constant.ShelterTypes;
import com.zorgundostu.shelter.constant.StatusTypes;
import com.zorgundostu.shelter.exception.ShelterError;
import com.zorgundostu.shelter.model.offer.OffererCreateDto;
import com.zorgundostu.shelter.model.offer.OffererDto;
import com.zorgundostu.shelter.model.request.RequesterCreateDto;
import com.zorgundostu.shelter.model.request.RequesterDto;
import com.zorgundostu.shelter.model.statistics.StatisticDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Tag(name = "Booking")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/shelters")
public interface ShelterApi {

    @Operation(operationId = "createRequester", summary = "Create requester item.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = RequesterCreateDto.class))),
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = RequesterDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ShelterError.class)))
    })
    @PostMapping(value = "requesters", produces = {"application/json;charset=utf-8"})
    ResponseEntity<Object> createRequester(@RequestHeader Map<String, String> header, @Valid @RequestBody RequesterCreateDto requesterCreateDto);

    @Operation(operationId = "getAllRequestersPaginated", summary = "Get all requesters items with pagination.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(array = @ArraySchema(schema = @Schema(implementation = RequesterDto.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ShelterError.class)))
    })
    @GetMapping(value = "requesters", produces = {"application/json;charset=utf-8"})
    ResponseEntity<Object> getAllRequesters(@RequestHeader Map<String, String> header,
                                            @RequestParam(defaultValue = "0", required = false) int page,
                                            @RequestParam(defaultValue = "10", required = false) int size);

    @Operation(operationId = "createOfferer", summary = "Create offerer item.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = OffererCreateDto.class))),
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = OffererDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ShelterError.class)))
    })
    @PostMapping(value = "offerers", produces = {"application/json;charset=utf-8"})
    ResponseEntity<Object> createOfferer(@RequestHeader Map<String, String> header, @Valid @RequestBody OffererCreateDto offererCreateDto);

    @Operation(operationId = "getAllOfferersPaginated", summary = "Get all offerers items with pagination.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OffererDto.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ShelterError.class)))
    })
    @GetMapping(value = "offerers", produces = {"application/json;charset=utf-8"})
    ResponseEntity<Object> getAllOfferers(@RequestHeader Map<String, String> header,
                                          @RequestParam(defaultValue = "0", required = false) int page,
                                          @RequestParam(defaultValue = "10", required = false) int size);

    @Operation(operationId = "getStatistics", summary = "Get statistics of offer and requester.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(array = @ArraySchema(schema = @Schema(implementation = StatisticDto.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ShelterError.class)))
    })
    @GetMapping(value = "stats", produces = {"application/json;charset=utf-8"})
    ResponseEntity<Object> getStatistics(@RequestHeader Map<String, String> header);

    @Operation(operationId = "updateStatus", summary = "Update provider or requester status.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(array = @ArraySchema(schema = @Schema(implementation = StatisticDto.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = ShelterError.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = ShelterError.class)))
    })
    @PutMapping(value = "/{type}/status/{status}/{id}", produces = {"application/json;charset=utf-8"})
    ResponseEntity<Object> updateStatus(@RequestHeader Map<String, String> header, @PathVariable(value = "type") ShelterTypes shelterType, @PathVariable(value = "status") StatusTypes statusType, @PathVariable(value = "id") String id);



}
