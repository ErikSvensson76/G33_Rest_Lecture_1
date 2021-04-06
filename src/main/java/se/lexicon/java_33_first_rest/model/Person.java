package se.lexicon.java_33_first_rest.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
