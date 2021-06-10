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
public class TemaController{

        @Autowired
        private TemaRepository temaRepository;

        @GetMapping // BUSCANDO TODOS OS TEMAS
        public ResponseEntity<List<Tema>> GetAll(){
            return ResponseEntity.ok(temaRepository.findAll());
        }

        @GetMapping("/{id}") // BUSCANDO UM TEMA PELO ID 
        public ResponseEntity<Tema> GetById(@PathVariable long id){
            return temaRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/tema/{tema}") // BUSCANDO TEMA PELO (ATRIBUTO)TEMA
        public ResponseEntity<List<Tema>> GetByTema(@PathVariable String tema){
            return ResponseEntity.ok(temaRepository.findAllByTemaContainingIgnoreCase(tema));
        }

        @GetMapping("/palavrachave/{palavrachave}") // BUSCANDO PELA (ATRIBUTO)PALAVRA CHAVE
        public ResponseEntity<List<Tema>> GetByPalavra(@PathVariable String tema){
            return ResponseEntity.ok(temaRepository.findAllByTemaContainingIgnoreCase(tema));
        }
        
        @PostMapping // POSTANDO UM TEMA
        public ResponseEntity<Tema> post(@RequestBody Tema tema){
            return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
        }

        @PutMapping // EDITANDO UM TEMA
        public ResponseEntity<Tema> put(@RequestBody Tema tema){
            return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(tema));
        }

        @DeleteMapping("/{id}") // EXCLUINDO UM TEMA
	    public void delete(@PathVariable long id) {
		    temaRepository.deleteById(id);		
	    }
}