package br.com.fiap.cp2.dto;

import br.com.fiap.cp2.entity.ToySize;
import jakarta.validation.constraints.*;

public record ToyDTO(

        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        String type,

        @NotNull
        @NotBlank
        String classification,

        @NotNull
        ToySize size,

        @NotNull
        @Digits(integer = 10, fraction = 2)
        Double price ) {
}
