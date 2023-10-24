package com.assessment.devsu.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaDTO {

    private Integer idPersona;
    @Parsed
    private String nombre;
    @Parsed
    private String genero;
    @Parsed
    private Integer edad;
    @Parsed
    private String identificacion;
    @Parsed
    private String direccion;
    @Parsed
    private String telefono;
}
