package com.generation.lojagames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.lojagames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	//select * from tb_produtos nome
	public List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	public List<Produto> findAllByValorGreaterThanEqual(@Param("valor") BigDecimal valor);
	public List<Produto> findAllByValorLessThanEqual(@Param("valor") BigDecimal valor);
	public List<Produto> findAllByValorBetween(@Param("valor1") BigDecimal valor1, @Param("valor2") BigDecimal valor2);

	

}
