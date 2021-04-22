package br.com.controlefrota.condutor.controller;

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

import br.com.controlefrota.condutor.models.Condutor;
import br.com.controlefrota.condutor.repository.CondutorRepository;

@RestController
@RequestMapping(value="/")
public class CondutorController {

	@Autowired
	CondutorRepository condutorRepository;
	
	@GetMapping("/condutor")
	public List<Condutor> listaCondutor(){
		return condutorRepository.findAll();
	}
	@GetMapping("/condutor/{id}")
	public Condutor listaUnicoCondutorPorId(@PathVariable(value="id") long id ){
		return condutorRepository.findById(id);
	}
	@GetMapping("/condutor/{cnh}/cnh")
	public Condutor listaUnicoCondutorPorCNH(@PathVariable(value="cnh") String cnh ){
		return condutorRepository.findByCNH(cnh);
	}

	@PostMapping("/condutor")
	public Condutor salvaCondutor(@RequestBody Condutor condutor) {
		return condutorRepository.save(condutor);
	}
	@PatchMapping("/condutor")
	public Condutor atualizarCondutor(@RequestBody Condutor condutor) {
		return condutorRepository.save(condutor);
	}
	@DeleteMapping("/condutor/{id}")
	public void deletarCondutor(@PathVariable(value="id") long id) {
		condutorRepository.deleteById(id);
	}
}
