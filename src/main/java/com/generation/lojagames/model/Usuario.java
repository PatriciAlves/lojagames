package com.generation.lojagames.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name= "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull(message = "Informe o nome do usuario")
	private String nome;
	
	@NotNull(message = "Informe um usuário")
	@Email(message = "Porfavor insira um email válido")
	private String usuario;
	
	@NotNull(message = "Informe uma senha de no min 8 caracteres")
	@Size(min=8, message = "a senha deve conter mo min 8 caracteres")
	private String senha;
	
	private String foto;
	
	@Column(name = "data_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "O atributo Data de Nascimento é Obrigatório!")
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	public List<Produto> produto;

}
