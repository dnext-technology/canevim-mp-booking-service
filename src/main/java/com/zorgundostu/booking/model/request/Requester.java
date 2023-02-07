package com.zorgundostu.booking.model.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("requesters")
public class Requester {

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
    private String neighborhood;
    private String addressDetail;
    @NotNull
    private int adultNumber;
    private int childNumber;
    @NotNull
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
