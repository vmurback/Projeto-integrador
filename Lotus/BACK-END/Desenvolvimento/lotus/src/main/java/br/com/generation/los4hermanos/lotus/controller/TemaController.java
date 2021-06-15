package br.com.generation.los4hermanos.lotus.controller;

import java.util.*;
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
import br.com.generation.los4hermanos.lotus.model.Tema;
import br.com.generation.los4hermanos.lotus.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

    // injetando dependecia da classe de Serviço
    @Autowired
    private TemaRepository temaRepository;

    // Endpoint buscando todas as postagens
    @GetMapping 
    public ResponseEntity<List<Tema>> GetAll() {
        return ResponseEntity.ok(temaRepository.findAll());
    }

    // Endpoint buscando a postagem pelo id
    @GetMapping("/{id}") 
    public ResponseEntity<Tema> GetById(@PathVariable long id) {
        return temaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint buscando a postagem pelo tema
    @GetMapping("/nome/{nome}") 
    public ResponseEntity<List<Tema>> GetByTema(@PathVariable String nome) {
        return ResponseEntity.ok(temaRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    // Endpoint buscando pela palavra chave
    @GetMapping("/palavrachave/{palavrachave}") 
    public ResponseEntity<List<Tema>> GetByPalavra(@PathVariable String palavrachave) {
        return ResponseEntity.ok(temaRepository.findAllByPalavraChaveContainingIgnoreCase(palavrachave));
    }

    // Endpoint Criando novo tema
    @PostMapping 
    public ResponseEntity<Tema> post(@RequestBody Tema tema) {
        return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
    }

    // Endpoint alterando um tema existente
    @PutMapping 
    public ResponseEntity<Tema> put(@RequestBody Tema tema) {
        return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(tema));
    }

    // Endpoint deletando um tema
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable long id) {
        temaRepository.deleteById(id);
    }

}
