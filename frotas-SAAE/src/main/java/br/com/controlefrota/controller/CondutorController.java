package br.com.controlefrota.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.model.Condutor;

@RestController
@RequestMapping("/condutores")
public interface CondutorController {

	@GetMapping("/{id}")
	public ResponseEntity<?> listaUnicoCondutorPorId(@PathVariable(value = "id") long id);
	
	@GetMapping("/{cnh}/cnh")
	public ResponseEntity<?> listaUnicoCondutorPorCNH(@PathVariable(value = "cnh") String cnh);
	
	@PostMapping
	public ResponseEntity<?> salvaCondutor(@RequestBody Condutor condutor);
	
	@PatchMapping
	public Condutor atualizarCondutor(@RequestBody Condutor condutor);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCondutor(@PathVariable(value = "id") long id);
	
	
}
