package com.freyr.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "clients")
public class Client {
    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String urlPhoto;
}
