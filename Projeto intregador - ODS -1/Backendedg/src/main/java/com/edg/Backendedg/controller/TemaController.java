package com.edg.Backendedg.controller;

import java.time.LocalDate;
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

import com.edg.Backendedg.model.Tema;
import com.edg.Backendedg.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

	
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/area/{area}")
	public ResponseEntity<List<Tema>> GetByArea(@PathVariable String area){
		return ResponseEntity.ok(repository.findAllByAreaContainingignoreCase(area));
	}
	
	@GetMapping("/tipo_de_acao/{tipo_de_acao}")
	public ResponseEntity<List<Tema>> GetByTipodeAcao (@PathVariable String tipo_de_acao){
		return ResponseEntity.ok(repository.findAllByTipo_de_acaoContainingignoreCase(tipo_de_acao));
	}
	
	@GetMapping("/publico/{publico}")
	public ResponseEntity<List<Tema>> GetByPublico (@PathVariable String publico){
		return ResponseEntity.ok(repository.findAllByPublicoContainingIgnoreCase(publico));
	}
	
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Tema>> GetByCidade (@PathVariable String cidade){
		return ResponseEntity.ok(repository.findAllByCidadeContainingIgnoreCase(cidade));
	}
	
	@GetMapping("/data/{data}")
	public ResponseEntity<List<Tema>> GetByData (@PathVariable LocalDate data){
		return ResponseEntity.ok(repository.findAllByData(data));
	}
	
	@PostMapping
	public ResponseEntity<Tema> Post(@RequestBody Tema post){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	
	@PutMapping
	public ResponseEntity<Tema> Put(@RequestBody Tema put){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(put));
	}
	
	@DeleteMapping("/{id}")
	public String Delete(@PathVariable long id) {
		repository.deleteById(id);
		return "Post deletado";
	}
}