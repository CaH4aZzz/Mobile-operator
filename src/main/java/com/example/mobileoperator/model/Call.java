package com.example.mobileoperator.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "calls")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//
//    @Column(name = "client_id")
//    private Long clientId;

    @Column(name = "client_number")
    private String phoneNumber;

    @Column(name = "recipient_number")
    private String recipientNumber;

    @Column(name = "call_date")
    @Temporal(TemporalType.DATE)
    private Date callDate;

    @Column(name = "call_time")
    @Temporal(TemporalType.TIME)
    private Date callTime;

    @Column(name = "call_duration")
    private Long duration;


}
