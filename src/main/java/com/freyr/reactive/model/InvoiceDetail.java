package com.freyr.reactive.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceDetail {

    private int quantity;
    private Dish dish;
}
