package org.eduardomango.practicaspringweb.model.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "Debe pasar un nombre de usuario")
    private String username;

    @NotBlank(message = "El e-mail no puede quedar en blanco")
    private String email;

    @NotBlank(message = "Debe elegir una cotraseña")
    @Max(value = 8,message = "no puede contener mas de 8 caracteres")
    @Min(value = 5,message = "Debe tener minimo 5 caracteres")
    private String password;


}
