package br.com.fiap.cp2.repository;

import br.com.fiap.cp2.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, Long> {
}
