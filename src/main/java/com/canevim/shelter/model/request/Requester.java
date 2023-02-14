package com.canevim.shelter.model.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.canevim.shelter.model.request.guest.Guest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Entity(name = "requesters")
@Table("requesters")
public class Requester {

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
    @Column(name = "neighborhood")
    private String neighborhood;
    @Column(name = "address_detail")
    private String addressDetail;
    @NotNull
    @Column(name = "adult_number")
    private int adultNumber;
    @Column(name = "child_number")
    private int childNumber;
    @NotNull
    @Column(name = "accommodation_period")
    private String accommodationPeriod;
    @Column(name = "transportation_required")
    private boolean transportationRequired;
    @Column(name = "note")
    private String note;
    @Column(name = "status")
    private String status;
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;
    @Version
    @Column(name = "version")
    private int version;

    @OneToMany(mappedBy = "requester", cascade = CascadeType.ALL)
    private List<Guest> guestList;

}
