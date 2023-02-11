package com.zorgundostu.shelter.model.provider;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("offerers")
public class Offerer {
    @Id
    private UUID id;
    @NotNull
    private String code;
    @NotNull
    private String identityNumber;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private LocalDate birthDate;
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String city;
    @NotNull
    private String district;
    private String town;
    @NotNull
    private String neighborhood;
    private String addressDetail;
    private int guestCapacity;
    private String accommodationType;
    private String accommodationPeriod;
    private LocalDate accommodationAvailabilityDate;
    private int accommodationAvailabilityDay;
    private String roomType;
    private boolean furnished;
    private String note;
    private String status;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @Version
    private int version;
}
