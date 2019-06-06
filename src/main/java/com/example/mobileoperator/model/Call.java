package com.example.mobileoperator.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "calls")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "client_number")
    private String phoneNumber;

    @Column(name = "recipient_number")
    private String recipientNumber;

    @Column(name = "call_date")
    @Temporal(TemporalType.DATE)
    private LocalDate callDate;

    @Column(name = "call_time")
    @Temporal(TemporalType.TIME)
    private LocalTime callTime;

    @Column(name = "call_duration")
    private Long duration;


}
