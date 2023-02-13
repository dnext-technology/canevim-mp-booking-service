package com.canevim.shelter.model.offer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity(name = "offerers")
@Table("offerers")
public class Offerer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotNull
    @Column(name = "code")
    private String code;
    @NotNull
    @Column(name = "identity_number")
    private String identityNumber;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "phone")
    private String phone;
    @NotNull
    @Column(name = "city")
    private String city;
    @NotNull
    @Column(name = "district")
    private String district;
    @Column(name = "town")
    private String town;
    @NotNull
    @Column(name = "neighborhood")
    private String neighborhood;
    @Column(name = "address_detail")
    private String addressDetail;
    @Column(name = "guest_capacity")
    private int guestCapacity;
    @Column(name = "accommodation_type")
    private String accommodationType;
    @Column(name = "accommodation_period")
    private String accommodationPeriod;
    @Column(name = "accommodation_availability_date")
    private LocalDate accommodationAvailabilityDate;
    @Column(name = "accommodation_availability_day")
    private int accommodationAvailabilityDay;
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "furnished")
    private boolean furnished;
    @Column(name = "note")
    private String note;
    @Column(name = "status")
    private String status;
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;
    @Column(name = "version")
    @Version
    private int version;
}
