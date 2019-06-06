package com.example.mobileoperator.model;

import com.example.mobileoperator.converter.GenderConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @NotEmpty
    @Column(name = "gender")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @NotNull
    @Column(name = "phone_number")
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set phoneNumber;
}
