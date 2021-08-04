package com.edg.Backendedg.controller;

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

import com.edg.Backendedg.model.ModelPostagem;
import com.edg.Backendedg.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin ("*")
public class Postagemcontroller {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ModelPostagem>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModelPostagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<ModelPostagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<ModelPostagem> Post(@RequestBody ModelPostagem post){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	
	@PutMapping
	public ResponseEntity<ModelPostagem> Put(@RequestBody ModelPostagem put){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(put));
	}
	
	@DeleteMapping("/{id}")
	public String Delete(@PathVariable long id) {
		repository.deleteById(id);
		return "Post deletado";
	}
}