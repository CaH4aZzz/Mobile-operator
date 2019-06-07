package com.example.mobileoperator.configuration;

import com.example.mobileoperator.model.Call;
import com.example.mobileoperator.model.Client;
import com.example.mobileoperator.model.Gender;
import com.example.mobileoperator.model.PhoneNumber;
import com.example.mobileoperator.repository.CallRepository;
import com.example.mobileoperator.repository.ClientRepository;
import com.example.mobileoperator.repository.PhoneNumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(ClientRepository repository, PhoneNumberRepository phoneNumberRepository,
                                   CallRepository callRepository) {
        return args -> {

            ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(new PhoneNumber("11111111111"));
            phoneNumbers.add(new PhoneNumber("77777777777"));

            ArrayList<PhoneNumber> phoneNumbers1 = new ArrayList<>();
            phoneNumbers1.add(new PhoneNumber("22222222222"));
            phoneNumbers1.add(new PhoneNumber("33333333333"));

            Client client1 = new Client("Oleg", "Ivaniv", new Date("1990/11/11"), Gender.MALE, phoneNumbers);
            Client client2 = new Client("Oleg2", "Ivaniv2", new Date("1992/12/12"), Gender.MALE, phoneNumbers1);

            log.info("Preload " + repository.save(client1));
            log.info("Preload " + repository.save(client2));

            PhoneNumber phoneNumber1 = new PhoneNumber(client1, "123345567123");
            PhoneNumber phoneNumber2 = new PhoneNumber(client1, "000000000000");

            log.info("Preload " + phoneNumberRepository.save(phoneNumber1));
            log.info("Preload " + phoneNumberRepository.save(phoneNumber2));

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            log.info("Preload " + callRepository.save(new Call(1L, 1L, "123", "123",
                    LocalDate.parse("2019-06-05", dateFormat), LocalTime.now(), 123L, "Dnipro")));
            log.info("Preload " + callRepository.save(new Call(2L, 1L, "123", "123",
                    LocalDate.parse("2019-04-07", dateFormat), LocalTime.now(), 123L, "Dnipro")));
            log.info("Preload " + callRepository.save(new Call(3L, 2L, "2222", "1111",
                    LocalDate.parse("2019-06-04", dateFormat), LocalTime.now(), 1232L, "Lutsk")));
            log.info("Preload " + callRepository.save(new Call(4L, 1L, "1111", "1111",
                    LocalDate.parse("2019-05-29", dateFormat), LocalTime.now(), 123L, "Lutsk")));
            log.info("Preload " + callRepository.save(new Call(5L, 1L, "123", "123",
                    LocalDate.parse("2019-06-03", dateFormat), LocalTime.now(), 123L, "Lutsk")));
            log.info("Preload " + callRepository.save(new Call(6L, 2L, "4444", "7777",
                    LocalDate.parse("2019-06-04", dateFormat), LocalTime.now(), 123L, "Lvov")));
        };
    }
}
