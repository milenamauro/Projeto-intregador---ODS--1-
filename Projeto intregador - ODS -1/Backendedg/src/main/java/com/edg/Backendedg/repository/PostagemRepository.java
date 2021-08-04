package com.edg.Backendedg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edg.Backendedg.model.ModelPostagem;
 

@Repository
public interface PostagemRepository extends JpaRepository<ModelPostagem, Long> {
	public List<ModelPostagem>findAllByTituloContainingIgnoreCase(String titulo);
}