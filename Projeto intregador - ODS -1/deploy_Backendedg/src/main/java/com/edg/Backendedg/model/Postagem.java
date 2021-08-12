
package com.edg.Backendedg.model;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem { 
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Long id;
		
	  @NotBlank 
		@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
		private String titulo;
	  
		
	  @NotBlank 
		@Size(min = 1, max = 255, message = "Limite de 255 caracteres")
		private String descricao;
	  
	  
	    private int like;
	  
	  
	  @NotBlank  
		@Size(min = 1, max = 350, message = "Limite de 350 caracteres")
		private String midia;
	  
	  @NotBlank  
		@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
		private String quemFaz;
	  
	  @ManyToOne
		@JsonIgnoreProperties("postagens")
		private Tema tema;
		
		@ManyToOne
		@JsonIgnoreProperties("postagens")
		private Usuario usuario;	
		

		public Tema getTema() {
			return tema;
		}

		public void setTema(Tema tema) {
			this.tema = tema;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public int getLike() {
			return like;
		}

		public void setLike(int like) {
			this.like = like;
		}

		public String getMidia() {
			return midia;
		}

		public void setMidia(String midia) {
			this.midia = midia;
		}

		public String getQuem_faz() {
			return quemFaz;
		}

		public void setQuem_faz(String quem_faz) {
			this.quemFaz = quem_faz;
		}
		
			
		
	}