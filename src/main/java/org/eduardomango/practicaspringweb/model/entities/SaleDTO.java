package org.eduardomango.practicaspringweb.model.entities;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class SaleDTO {

    @NotBlank(message = "Debe pasar un id de producto")
    private Long idProducto;

    @NotBlank(message = "Debe pasar un id de cliente")
    private Long idCliente;

    @NotBlank(message = "DEbe pasar una cantidad comprada")
    @Max(value = 100,message = "No puede comprar mas de 100 articulos")
    @Positive(message = "No puede ser cantidad negativa")
    private Long cantidad;

}
