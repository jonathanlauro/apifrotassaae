package br.com.controlefrota.controller.impl;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.controller.CombustivelController;
import br.com.controlefrota.model.Combustivel;
import br.com.controlefrota.repository.CombustivelRepository;
import br.com.controlefrota.service.impl.CombustivelServiceEJB;

@RestController
public class CombustivelControllerImpl implements CombustivelController{

	@Autowired
	CombustivelRepository combustivelRepository;
	@Autowired
	CombustivelServiceEJB combustivelService;
	
	@Override
	public List<Combustivel> listaCombustivel(){
		return combustivelRepository.findAll();
	}
	@Override
	public ResponseEntity<?> listaUnicoCombustivel(@PathVariable(value="id") long id ){

		try {
			return new ResponseEntity<Combustivel>(combustivelService.findById(id),HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found! "+e);
		}
	}
	@Override
	public ResponseEntity<?> cadastraCombustivel(@RequestBody Combustivel combustivel ) {
		try {
			
			combustivelService.cadastrar(combustivel);
			return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com sucesso.");
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar! "+e);
		}
	}
	@Override
	public Combustivel updateCombustivel(@RequestBody Combustivel combustivel ) {
		return combustivel;
	}
	@Override
	public void deleteCombustivel(@PathVariable(value="id") Long id ) {
		combustivelRepository.deleteById(id);
	}
}
