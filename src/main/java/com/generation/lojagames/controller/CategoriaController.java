package com.generation.lojagames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojagames.model.Categoria;
import com.generation.lojagames.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders  = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository cat;
	
	// Lista todos os produtos
		@GetMapping("/all")
		public ResponseEntity<List<Categoria>> getAll() {
			return ResponseEntity.ok(cat.findAll());
		}

		// Busca por id
		@GetMapping("/{id}")
		public ResponseEntity<Categoria> getById(@PathVariable Long id) {
			return cat.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}

		// Busca por nome
		@GetMapping("/tipo/{tipo}")
		public ResponseEntity<List<Categoria>> getByNome(@PathVariable String tipo) {
			return ResponseEntity.ok(cat.findAllByTipoContainingIgnoreCase(tipo));
		}

		// Cria produto
		@PostMapping
		public ResponseEntity<Categoria> postProduto(@Valid @RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.CREATED).body(cat.save(categoria));
				
		}
		// Atualiza produto
		@PutMapping
		public ResponseEntity<Categoria> updateCat(@Valid @RequestBody Categoria categoria) {
				return cat.findById(categoria.getId())
						.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(cat.save(categoria)))
						.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
			
			
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteCat(@PathVariable Long id){
			return cat.findById(id)
					.map(resposta -> { 
						cat.deleteById(id);
							return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				
				})
				.orElse(ResponseEntity.notFound().build());
		}

}
