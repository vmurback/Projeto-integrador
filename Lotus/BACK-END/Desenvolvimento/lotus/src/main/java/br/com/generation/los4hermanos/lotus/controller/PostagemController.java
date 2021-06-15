package br.com.generation.los4hermanos.lotus.controller;

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
import br.com.generation.los4hermanos.lotus.model.Postagem;
import br.com.generation.los4hermanos.lotus.repository.PostagemRepository;


@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins= "*", allowedHeaders= "*")
public class PostagemController {

    // injetando dependecia da classe de Serviço
    @Autowired
    private PostagemRepository postagemRepository;

    // @Autowired
    // private UsuarioRepository usuarioRepository;

    // buscando todas as postagens
    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    // buscando a postagem pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable long id) {
        return postagemRepository.findById(id)
            .map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    // buscando a postagem pelo titulo
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    }


    // // buscando postagens por determinado score
    // @GetMapping("/score/{score}")
    // public ResponseEntity<List<Usuario>> getByScore(@PathVariable int score) {
    //     return ResponseEntity.ok(usuarioRepository.findAllByScore(score));

    // }
    // Criando nova postagem
    @PostMapping
    public ResponseEntity<Postagem> postTema(@RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
    }

    //alterando uma postagem existente
    @PutMapping
    public ResponseEntity<Postagem> putTema(@RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
    }

    //deletando uma postagem
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        postagemRepository.deleteById(id);
    }

}
