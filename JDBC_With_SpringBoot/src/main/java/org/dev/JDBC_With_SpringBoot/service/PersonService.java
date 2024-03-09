package org.dev.JDBC_With_SpringBoot.service;

import org.dev.JDBC_With_SpringBoot.model.Person;
import org.dev.JDBC_With_SpringBoot.requests.PersonRequestData;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonService {
    private Integer calculateAge(String dob){
        if(dob == null){
            return  0;
        }
        // see todays date
        // see his dob
        // diff
        // year
        LocalDate dobDate = LocalDate.parse(dob);
        LocalDate date= LocalDate.now();
        return Period.between(date, dobDate).getYears();
    }
    public void createPerson(PersonRequestData personRequestData){
        // add this object to my db
        // add some business logic

        // if i wanted needed to hit 3rd party apis
        // age from dob
        Person p = personRequestData.to();
        int age =0;
        if(p.getAge() == null){
            age = calculateAge(personRequestData.getDob());
            p.setAge(age);
        }
        // i wanted to save it
        // i should be going to repo



    }

}
