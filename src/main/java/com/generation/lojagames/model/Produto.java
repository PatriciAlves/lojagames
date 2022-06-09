package com.generation.lojagames.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



@Data
@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Porfavor insira o nome do Jogo!")
	private String nome;
	
	@NotBlank(message = "Porfavor insira uma descrição, e não apenas espaços em branco.")
	@Size(min=15, max = 500, message = "Descrição deve conter no min 15 caracteres e no max 500.")
	private String descricao;
	
	@NotNull(message = "Informe o console, ex: PS4.")
	private String console;
	
	@NotNull(message = "Informe a quantidade desejada. ")
	private int qtd;
	
	@NotNull(message = "Informe o preço do Jogo.")
	private BigDecimal valor;
	
	private String foto;
	
	@Column(name = "data_lancamento")
	private LocalDate dataLancamento;
	
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	public Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	public Usuario usuario;
	

}
