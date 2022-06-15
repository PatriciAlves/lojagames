package com.generation.lojagames.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.lojagames.model.Produto;
import com.generation.lojagames.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository prodRepository;
	
	public Optional<Produto> curtir (long id){
		if(prodRepository.existsById(id)) {
			Produto produto = prodRepository.findById(id).get();
			produto.setCurtir(produto.getCurtir()+1);
			return Optional.of(prodRepository.save(produto));
		}
		return Optional.empty();
	}

}
