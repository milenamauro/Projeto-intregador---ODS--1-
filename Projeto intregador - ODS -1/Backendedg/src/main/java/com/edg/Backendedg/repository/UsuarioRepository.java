package com.edg.Backendedg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edg.Backendedg.model.Usuario;
 
 
	
	
	@Repository
	public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		public List<Usuario>findAllByNomeContainingIgnoreCase(String nome);
	}