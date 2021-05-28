package br.com.controlefrota.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.model.Combustivel;

@RestController
@RequestMapping(value="/combustivel")
public interface CombustivelController {

	@GetMapping
	public List<Combustivel> listaCombustivel();
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listaUnicoCombustivel(@PathVariable(value="id") long id );
	
	@PostMapping
	public ResponseEntity<?> cadastraCombustivel(@RequestBody Combustivel combustivel );
	
	@PatchMapping
	public Combustivel updateCombustivel(@RequestBody Combustivel combustivel );
	
	@DeleteMapping("/{id}")
	public void deleteCombustivel(@PathVariable(value="id") Long id );
}
