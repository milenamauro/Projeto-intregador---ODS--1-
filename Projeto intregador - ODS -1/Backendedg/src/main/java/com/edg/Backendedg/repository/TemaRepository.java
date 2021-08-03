package com.edg.Backendedg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edg.Backendedg.model.ModelTema;

 
	
	@Repository
	public interface TemaRepository  extends JpaRepository<ModelTema, Long>{
  

		public List<ModelTema> findAllByAreaContainingignoreCase(String area);
		public List<ModelTema> findAllByTipo_de_acaoContainingignoreCase(String tipo_de_acao);
		public List<ModelTema>findAllByPublicoContainingIgnoreCase(String publico);
		public List<ModelTema>findAllByCidadeContainingIgnoreCase(String cidade);
		public List<ModelTema> findAllByContainingignoreCase(LocalDate data); 
		
		
		
		
}
