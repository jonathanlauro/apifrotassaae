package br.com.controlefrota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.model.Combustivel;
import br.com.controlefrota.repository.CombustivelRepository;

@RestController
@RequestMapping(value="/")
public class CombustivelController {

	@Autowired
	CombustivelRepository combustivelRepository;
	
	@GetMapping("/combustivel")
	public List<Combustivel> listaCombustivel(){
		return combustivelRepository.findAll();
	}
	@GetMapping("/combustivel/{id}")
	public Combustivel listaUnicoCombustivel(@PathVariable(value="id") long id ){
		return combustivelRepository.findById(id);
	}
	@PostMapping("/combustivel")
	public Combustivel cadastraCombustivel(@RequestBody Combustivel combustivel ) {
		return combustivel;
	}
	@PatchMapping("/combustivel")
	public Combustivel updateCombustivel(@RequestBody Combustivel combustivel ) {
		return combustivel;
	}
	@DeleteMapping("/combustivel/{id}")
	public void deleteCombustivel(@PathVariable(value="id") Long id ) {
		combustivelRepository.deleteById(id);
	}
}
