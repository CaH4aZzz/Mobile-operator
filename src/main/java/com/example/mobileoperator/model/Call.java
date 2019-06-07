package com.example.mobileoperator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
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
    private LocalDateTime callDate;

    @Column(name = "call_duration")
    private Long duration;

    @Column(name = "city_name")
    private String city;

    public Call() {
    }

    public Call(String phoneNumber, String recipientNumber, LocalDateTime callDate, Long duration, String city) {
        this.phoneNumber = phoneNumber;
        this.recipientNumber = recipientNumber;
        this.callDate = callDate;
        this.duration = duration;
        this.city = city;
    }
}
