package br.com.fiap.cp2.controller;

import br.com.fiap.cp2.dto.ToyDTO;
import br.com.fiap.cp2.dto.ToyDetailsDTO;
import br.com.fiap.cp2.entity.Toy;
import br.com.fiap.cp2.repository.ToyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/toys")
public class ToyController {

    @Autowired
    private ToyRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid ToyDTO toyDTO, UriComponentsBuilder uriBuilder) {
        var toy = new Toy(toyDTO);
        repository.save(toy);

        var uri = uriBuilder.path("/toys/{id}").buildAndExpand(toy.getId()).toUri();

        return ResponseEntity.created(uri).body(new ToyDetailsDTO(toy));
    }

    @GetMapping
    public ResponseEntity<Page<ToyDetailsDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(ToyDetailsDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody ToyDetailsDTO toyDetailsDTO) {
        var toy = repository.getReferenceById(toyDetailsDTO.id());
        toy.update(toyDetailsDTO);

        return ResponseEntity.ok(new ToyDetailsDTO(toy));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var toy = repository.getReferenceById(id);
        return ResponseEntity.ok(new ToyDetailsDTO(toy));
    }

}
