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

import br.com.controlefrota.model.Trabalho;
import br.com.controlefrota.repository.TrabalhoRepository;
import br.com.controlefrota.service.TrabalhoService;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {
	@Autowired
	TrabalhoRepository trabalhoRepository;
	@Autowired
	TrabalhoService trabalhoService;

	@GetMapping
	public List<Trabalho> listatrabalhos() {
		return trabalhoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listaUnicotrabalhoPorId(@PathVariable(value="id") long id) {

		try {
			return new ResponseEntity<Trabalho>(trabalhoService.findById(id), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! "+e);
		}
	}

	@PostMapping
	public ResponseEntity<?> salvatrabalho(@RequestBody Trabalho trabalho) {
		try {			
			trabalhoService.criar(trabalho);
			return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com sucesso");
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar trabalho! " + e);
		}
	}
	@GetMapping("/encerrarTrabalho/{idTrabalho}")
	public ResponseEntity<?> encerrarTrabalho(@PathVariable(value="idTrabalho") Long id){
		try {
			trabalhoService.encerrarTrabalho(id);
			return ResponseEntity.status(HttpStatus.OK).body("Trabalho Encerrado");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao encerrar trabalho! " + e);
		}
		
	}
	@GetMapping("/{status}/status-trabalho")
	public List<Trabalho> listarPorStatus(@PathVariable(value="status") String status){
		return trabalhoRepository.findByStatusTrabalho(status);
	}
	@PatchMapping
	public Trabalho atualizartrabalho(@RequestBody Trabalho trabalho) {
		return trabalhoRepository.save(trabalho);
	}

	@DeleteMapping("/{id}")
	public void deletartrabalho(@PathVariable Long id) {
		trabalhoRepository.deleteById(id);
	}
}
