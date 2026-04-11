package org.eduardomango.practicaspringweb.model.entities;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class SaleResponse {

    private Long id;
    private ProductEntity products;
    private Long quantity;
    private UserEntity client;
}
