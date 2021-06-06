package br.com.generation.los4hermanos.saltoalto.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.generation.los4hermanos.saltoalto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
    
}
