package com.example.mobileoperator.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @NotEmpty
    @Column(name = "number")
    private String number;

    public PhoneNumber(Client client, @NotEmpty String number) {
        this.client = client;
        this.number = number;
    }

    public PhoneNumber(@NotEmpty String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
