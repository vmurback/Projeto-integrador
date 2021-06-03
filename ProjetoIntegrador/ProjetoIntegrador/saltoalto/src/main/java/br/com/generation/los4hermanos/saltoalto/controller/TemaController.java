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

import br.com.generation.los4hermanos.saltoalto.model.Tema;
import br.com.generation.los4hermanos.saltoalto.repository.TemaRepository;



@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController{

        @Autowired
        private TemaRepository temaRepository;

        @GetMapping
        public ResponseEntity<List<Tema>> GetAll(){
            return ResponseEntity.ok(temaRepository.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Tema> GetById(@PathVariable long id){
            return temaRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/tema/{tema}")
        public ResponseEntity<List<Tema>> GetByTema(@PathVariable String tema){
            return ResponseEntity.ok(temaRepository.findAllByTemaContainingIgnoreCase(tema));
        }
        
        @PostMapping
        public ResponseEntity<Tema> post(@RequestBody Tema tema){
            return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
        }

        @PutMapping
        public ResponseEntity<Tema> put(@RequestBody Tema tema){
            return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(tema));
        }

        @DeleteMapping("/{id}")
	    public void delete(@PathVariable long id) {
		    temaRepository.deleteById(id);		
	    }
}