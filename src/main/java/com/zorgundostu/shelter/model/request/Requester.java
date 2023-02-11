package com.zorgundostu.shelter.model.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("requesters")
public class Requester {
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
    private String neighborhood;
    private String addressDetail;
    @NotNull
    private int adultNumber;
    private int childNumber;
    @NotNull
    private String accommodationPeriod;
    private boolean transportationRequired;
    private String note;
    private String status;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @Version
    private int version;
}
