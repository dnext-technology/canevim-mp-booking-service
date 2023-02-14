package com.canevim.shelter.model.request.guest;

import com.canevim.shelter.model.request.Requester;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;


@Data
@Entity(name = "guests")
@Table("guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotNull
    @Column(name = "identity_number")
    private String identityNumber;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "requester_id", foreignKey = @ForeignKey(name = "fk_guest_requester"))
    private Requester requester;


}