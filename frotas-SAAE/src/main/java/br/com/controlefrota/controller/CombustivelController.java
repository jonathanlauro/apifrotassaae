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

import br.com.controlefrota.model.CombustivelModel;
import br.com.controlefrota.repository.CombustivelRepository;
import br.com.controlefrota.service.CombustivelService;

@RestController
@RequestMapping(value="/")
public class CombustivelController {

	@Autowired
	CombustivelRepository combustivelRepository;
	@Autowired
	CombustivelService combustivelService;
	
	@GetMapping("/combustivel")
	public List<CombustivelModel> listaCombustivel(){
		return combustivelRepository.findAll();
	}
	@GetMapping("/combustivel/{id}")
	public ResponseEntity<?> listaUnicoCombustivel(@PathVariable(value="id") long id ){

		try {
			return new ResponseEntity<CombustivelModel>(combustivelService.findById(id),HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found! "+e);
		}
	}
	@PostMapping("/combustivel")
	public ResponseEntity<?> cadastraCombustivel(@RequestBody CombustivelModel combustivel ) {
		try {
			
			combustivelService.cadastrar(combustivel);
			return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com sucesso.");
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar! "+e);
		}
	}
	@PatchMapping("/combustivel")
	public CombustivelModel updateCombustivel(@RequestBody CombustivelModel combustivel ) {
		return combustivel;
	}
	@DeleteMapping("/combustivel/{id}")
	public void deleteCombustivel(@PathVariable(value="id") Long id ) {
		combustivelRepository.deleteById(id);
	}
}
