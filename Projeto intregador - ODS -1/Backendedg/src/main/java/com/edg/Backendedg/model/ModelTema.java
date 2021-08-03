package com.edg.Backendedg.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity //classe com atributos
@Table (name="tb_thema")
public class ModelTema {
  //Atributos
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank 
	@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
	private String area;
	
	@NotBlank 
	@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
	private String tipo_de_acao;
	
	@NotBlank  
	private LocalDate data;
	
	@NotBlank  
	@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
	private String publico;
	
	@NotBlank  
	@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
	private String cidade;
	
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
	public String getTipo_de_acao() {
		return tipo_de_acao;
	}
	public void setTipo_de_acao(String tipo_de_acao) {
		this.tipo_de_acao = tipo_de_acao;
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