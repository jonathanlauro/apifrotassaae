package br.com.controlefrota.controller.impl;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.controller.TrabalhoController;
import br.com.controlefrota.model.Trabalho;
import br.com.controlefrota.repository.TrabalhoRepository;
import br.com.controlefrota.service.impl.TrabalhoServiceEJB;

@RestController
public class TrabalhoControllerImpl implements TrabalhoController {

	@Autowired
	TrabalhoRepository trabalhoRepository;
	@Autowired
	TrabalhoServiceEJB trabalhoService;

	@Override
	public List<Trabalho> listatrabalhos() {
		return trabalhoService.findAll();
	}

	@Override
	public ResponseEntity<?> listaUnicotrabalhoPorId(@PathVariable(value = "id") long id) {

		try {
			return new ResponseEntity<Trabalho>(trabalhoService.findById(id), HttpStatus.OK);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! " + e);
		}
	}

	@Override
	public ResponseEntity<?> salvatrabalho(@RequestBody Trabalho trabalho) {
		try {
			trabalhoService.criar(trabalho);
			return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com sucesso");
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar trabalho! " + e);
		}
	}

	@Override
	public ResponseEntity<?> encerrarTrabalho(@PathVariable(value = "idTrabalho") Long id,
			@PathVariable(value = "kmFinal") String kmFinal) {
		try {
			trabalhoService.encerrarTrabalho(id, kmFinal);
			return ResponseEntity.status(HttpStatus.OK).body("Trabalho Encerrado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao encerrar trabalho! " + e);
		}

	}

	@Override
	public List<Trabalho> listarPorStatus(@PathVariable(value = "status") String status) {
		return trabalhoRepository.findByStatusTrabalho(status);
	}

	@Override
	public Trabalho atualizartrabalho(@RequestBody Trabalho trabalho) {
		return trabalhoRepository.save(trabalho);
	}

	@Override
	public ResponseEntity<?> deletartrabalho(@PathVariable Long id) {

		try {
			trabalhoService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Trabalho Deletado com sucesso! ");
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO DELETAR TRABALHO! " + exception);

		}
	}
}
