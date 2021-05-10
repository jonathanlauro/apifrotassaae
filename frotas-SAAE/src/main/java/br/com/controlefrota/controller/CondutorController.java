package br.com.controlefrota.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.model.CondutorModel;
import br.com.controlefrota.repository.CondutorRepository;
import br.com.controlefrota.service.CondutorService;

@RestController
@RequestMapping("/condutores")
public class CondutorController {

	@Autowired
	CondutorRepository condutorRepository;
	@Autowired
	CondutorService condutorService;
	
	@GetMapping
	public List<CondutorModel> listaCondutor() {

		return condutorService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listaUnicoCondutorPorId(@PathVariable(value = "id") long id) {
		try {
			
			return new ResponseEntity<CondutorModel>( condutorService.findById(id), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found! Condutor não encontrado ");
		}
	}

	@GetMapping("/{cnh}/cnh")
	public ResponseEntity<?> listaUnicoCondutorPorCNH(@PathVariable(value = "cnh") String cnh) {
	try {
			
			return new ResponseEntity<CondutorModel>( condutorService.findByCnh(cnh), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found! Condutor não encontrado ");
		}
	}

	@PostMapping
	public ResponseEntity<?> salvaCondutor(@RequestBody CondutorModel condutor) {
		try {
			
			condutorService.criar(condutor);
			return ResponseEntity.status(HttpStatus.OK).body("Condutor cadastrado com sucesso");
		}catch( ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar condutor! " + e);
		}
		
	}

	@PatchMapping
	public CondutorModel atualizarCondutor(@RequestBody CondutorModel condutor) {
		return condutorRepository.save(condutor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCondutor(@PathVariable(value = "id") long id) {
		try {
			
			condutorService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Condutor excluído com sucesso");
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar condutor! "+e);
		}
	}
}
