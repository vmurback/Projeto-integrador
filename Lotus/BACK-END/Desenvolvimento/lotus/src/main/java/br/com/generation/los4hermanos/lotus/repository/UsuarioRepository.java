package br.com.generation.los4hermanos.lotus.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.generation.los4hermanos.lotus.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findAllByUsuarioContainingIgnoreCase(String usuario);
    public Optional<Usuario> findAllByEmailContainingIgnoreCase(String email);
    // public Optional<Usuario> findAllByScore(int score);
    public Optional<Usuario> findAllByCpf(String cpf);
    
}
