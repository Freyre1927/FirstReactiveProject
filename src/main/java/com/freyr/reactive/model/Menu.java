package com.freyr.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "menus")
public class Menu {
    @Id
    private String id;
    private String icon;
    private String name;
    private String url;
    private List<String> roles;
}
