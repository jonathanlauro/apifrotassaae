package br.com.controlefrota.controller.impl;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.controller.CondutorController;
import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.repository.CondutorRepository;
import br.com.controlefrota.service.impl.CondutorServiceEJB;

@RestController
public class CondutorControllerImpl implements CondutorController{

	@Autowired
	CondutorRepository condutorRepository;
	@Autowired
	CondutorServiceEJB condutorService;
	
	@GetMapping
	public List<Condutor> listaCondutor() {

		return condutorService.findAll();
	}

	@Override
	public ResponseEntity<?> listaUnicoCondutorPorId(@PathVariable(value = "id") long id) {
		try {
			
			return new ResponseEntity<Condutor>( condutorService.findById(id), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found! Condutor não encontrado ");
		}
	}

	@Override
	public ResponseEntity<?> listaUnicoCondutorPorCNH(@PathVariable(value = "cnh") String cnh) {
	try {
			
			return new ResponseEntity<Condutor>( condutorService.findByCnh(cnh), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found! Condutor não encontrado ");
		}
	}

	@Override
	public ResponseEntity<?> salvaCondutor(@RequestBody Condutor condutor) {
		try {
			
			condutorService.criar(condutor);
			return ResponseEntity.status(HttpStatus.OK).body("Condutor cadastrado com sucesso");
		}catch( ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar condutor! " + e);
		}
		
	}

	@Override
	public Condutor atualizarCondutor(@RequestBody Condutor condutor) {
		return condutorRepository.save(condutor);
	}

	@Override
	public ResponseEntity<?> deletarCondutor(@PathVariable(value = "id") long id) {
		try {
			
			condutorService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Condutor excluído com sucesso");
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar condutor! "+e);
		}
	}
}
