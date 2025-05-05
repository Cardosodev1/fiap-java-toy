package br.com.fiap.cp2.entity;

import br.com.fiap.cp2.dto.ToyDTO;
import br.com.fiap.cp2.dto.ToyDetailsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_toys")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_toy")
    private Long id;

    @Column(name = "name_toy")
    private String name;

    @Column(name = "type_toy")
    private String type;

    @Column(name = "classification_toy")
    private String classification;

    @Enumerated(EnumType.STRING)
    @Column(name = "size_toy")
    private ToySize size;

    @Column(name = "price_toy")
    private Double price;

    public Toy(ToyDTO toyDTO) {
        this.name = toyDTO.name();
        this.type = toyDTO.type();
        this.classification = toyDTO.classification();
        this.size = toyDTO.size();
        this.price = toyDTO.price();
    }

    public void update(ToyDetailsDTO toyDetailsDTO) {
        if (toyDetailsDTO.name() != null) {
            this.name = toyDetailsDTO.name();
        }
        if (toyDetailsDTO.type() != null) {
            this.type = toyDetailsDTO.type();
        }
        if (toyDetailsDTO.classification() != null) {
            this.classification = toyDetailsDTO.classification();
        }
        if (toyDetailsDTO.size() != null) {
            this.size = toyDetailsDTO.size();
        }
        if (toyDetailsDTO.price() != null) {
            this.price = toyDetailsDTO.price();
        }
    }

}
