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
@Document(collection = "invoices")
public class Invoices {
    @Id
    private String id;
    private String description;
    private Client client;
    private List<InvoiceDetail> items;
}
