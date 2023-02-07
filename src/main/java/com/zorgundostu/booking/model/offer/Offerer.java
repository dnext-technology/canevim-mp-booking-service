package com.zorgundostu.booking.model.offer;

import java.time.Instant;
import java.time.LocalDateTime;

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
    private Long id;
    @NotNull
    private String identityNumber;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
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
    private String note;
    private String status;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @Version
    private int version;
}
