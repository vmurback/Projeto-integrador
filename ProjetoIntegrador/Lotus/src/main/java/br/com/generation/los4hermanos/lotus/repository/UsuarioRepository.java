package br.com.generation.los4hermanos.lotus.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.los4hermanos.lotus.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
 
    public Optional<Usuario> findByUsuario(String usuario);  
    
}
