package br.com.generation.los4hermanos.saltoalto.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.generation.los4hermanos.saltoalto.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    public List<Postagem> findAllByTituloContainingIgnoreCase(String postagem);
    
}
