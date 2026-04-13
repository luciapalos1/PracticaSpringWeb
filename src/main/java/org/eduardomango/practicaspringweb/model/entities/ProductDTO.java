package org.eduardomango.practicaspringweb.model.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductDTO {

    @NotBlank(message = "no puede quedar vacio")
    @Max(value = 20, message = "Tiene un maximo de 20 caracteres")
    private String name;

    @NotBlank(message = "Debe ingresar un precio")
    private double price;


    private String description;

}
