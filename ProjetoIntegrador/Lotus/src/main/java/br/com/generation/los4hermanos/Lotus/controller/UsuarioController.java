package br.com.generation.los4hermanos.saltoalto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.generation.los4hermanos.saltoalto.model.Usuario;
import br.com.generation.los4hermanos.saltoalto.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController{

        @Autowired
        private UsuarioRepository usuarioRepository;

        @GetMapping
        public ResponseEntity<List<Usuario>> GetAll(){
            return ResponseEntity.ok(usuarioRepository.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Usuario> GetById(@PathVariable long id){
            return usuarioRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/usuario/{usuario}")
        public ResponseEntity<List<Usuario>> GetByTema(@PathVariable String usuario){
            return ResponseEntity.ok(usuarioRepository.findAllByNomeContainingIgnoreCase(usuario));
        }
        
        @PostMapping
        public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
        }

        @PutMapping
        public ResponseEntity<Usuario> put(@RequestBody Usuario usuario){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
        }

        @DeleteMapping("/{id}")
	    public void delete(@PathVariable long id) {
		    usuarioRepository.deleteById(id);		
	    }
}