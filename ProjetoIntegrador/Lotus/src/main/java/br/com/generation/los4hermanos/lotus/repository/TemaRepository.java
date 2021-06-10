package br.com.generation.los4hermanos.lotus.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.los4hermanos.lotus.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    public List<Tema> findAllByTemaContainingIgnoreCase(String tema);
}

