package org.dev.JDBC_With_SpringBoot.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Person {
    String firstName;
    Integer id;
    String lastName;
    String dob;

    Integer age;

}
