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
@Table (name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotEmpty
    @Column(name = "birthday")
    private Date birthday;

    @NotNull
    @NotEmpty
    @Column(name = "gender")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @NotNull
    @Column(name = "phone_number")
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set phoneNumber;
}
