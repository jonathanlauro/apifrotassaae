package br.com.controlefrota.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.model.Trabalho;
import br.com.controlefrota.repository.CondutorRepository;

@RestController
@RequestMapping("/condutores")
public class CondutorController {

	@Autowired
	CondutorRepository condutorRepository;

	@GetMapping
	public List<Condutor> listaCondutor() {
//		var condutor = condutorRepository.findAll();
	
//		return condutor
//				.stream()
//				.map((c)-> Condutor.trabalhoConverte(c))
//				.collect(Collectors.toList());
//		
		return condutorRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Condutor> listaUnicoCondutorPorId(@PathVariable(value = "id") Long id) {
		return condutorRepository.findById(id);
	}

	@GetMapping("/{cnh}/cnh")
	public Condutor listaUnicoCondutorPorCNH(@PathVariable(value = "cnh") String cnh) {
		return condutorRepository.findByCNH(cnh);
	}

	@PostMapping
	public Condutor salvaCondutor(@RequestBody Condutor condutor) {
		return condutorRepository.save(condutor);
	}

	@PatchMapping
	public Condutor atualizarCondutor(@RequestBody Condutor condutor) {
		return condutorRepository.save(condutor);
	}

	@DeleteMapping("/{id}")
	public void deletarCondutor(@PathVariable(value = "id") long id) {
		condutorRepository.deleteById(id);
	}
}
