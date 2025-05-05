package br.com.fiap.cp2.dto;

import br.com.fiap.cp2.entity.Toy;
import br.com.fiap.cp2.entity.ToySize;

public record ToyDetailsDTO(Long id,
                            String name,
                            String type,
                            String classification,
                            ToySize size,
                            Double price) {

    public ToyDetailsDTO(Toy toy) {
        this(toy.getId(), toy.getName(), toy.getType(), toy.getClassification(), toy.getSize(), toy.getPrice());
    }

}
