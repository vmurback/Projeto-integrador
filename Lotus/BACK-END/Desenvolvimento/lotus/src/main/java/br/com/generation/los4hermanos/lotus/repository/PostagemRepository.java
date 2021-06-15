package br.com.generation.los4hermanos.lotus.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.generation.los4hermanos.lotus.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    public List<Postagem> findAllByTituloContainingIgnoreCase(String postagem); 
}
