package com.freyr.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Document(collection = "dishes")
public class Dish {
    @EqualsAndHashCode.Include
    @Id
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "price")
    private Double price;
    @Field(name = "status")
    private Boolean status;

}
