package com.example.mobileoperator.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Setter
@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @Pattern(regexp="([0-9])")
    @Column(name = "number", length = 12)
    private String number;
}
