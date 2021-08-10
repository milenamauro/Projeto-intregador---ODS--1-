package com.edg.Backendedg.model;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class Tema {
  //Atributos
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank 
	@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
	private String area;
	
	@NotBlank 
	@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
	private String tipodeacao;
	
	@NotBlank  
	private LocalDate data;
	
	@NotBlank  
	@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
	private String publico;
	
	@NotBlank  
	@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
	private String cidade;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagens;
	
	public List<Postagem> getPostagens() {
		return postagens;
	}
	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}	
	

	public String getTipoDeAcao() {
		return tipodeacao;
	}
	public void setTipoDeAcao(String tipoDeAcao) {
		this.tipodeacao = tipoDeAcao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getPublico() {
		return publico;
	}
	public void setPublico(String publico) {
		this.publico = publico;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	

}