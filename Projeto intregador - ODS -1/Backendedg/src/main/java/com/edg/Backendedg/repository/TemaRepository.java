package com.edg.Backendedg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edg.Backendedg.model.Tema;

 
	
	@Repository
	public interface TemaRepository  extends JpaRepository<Tema, Long>{
  

		public List<Tema> findAllByAreaContainingignoreCase(String area);
		public List<Tema> findAllByTipo_de_acaoContainingignoreCase(String tipo_de_acao);
		public List<Tema>findAllByPublicoContainingIgnoreCase(String publico);
		public List<Tema>findAllByCidadeContainingIgnoreCase(String cidade);
		public List<Tema> findAllByData(LocalDate data); 
		
		
		
		
}
