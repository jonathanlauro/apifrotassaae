package br.com.controlefrota.controller;

import java.util.List;

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

@RestController
@RequestMapping("/trabalhos")
public interface TrabalhoController {

	@GetMapping
	public List<Trabalho> listatrabalhos();

	@GetMapping("/{id}")
	public ResponseEntity<?> listaUnicotrabalhoPorId(@PathVariable(value = "id") long id);

	@PostMapping
	public ResponseEntity<?> salvatrabalho(@RequestBody Trabalho trabalho);

	@GetMapping("/encerrarTrabalho/{idTrabalho}/{kmFinal}")
	public ResponseEntity<?> encerrarTrabalho(@PathVariable(value = "idTrabalho") Long id,
			@PathVariable(value = "kmFinal") String kmFinal);

	@GetMapping("/{status}/status-trabalho")
	public List<Trabalho> listarPorStatus(@PathVariable(value = "status") String status);

	@PatchMapping
	public Trabalho atualizartrabalho(@RequestBody Trabalho trabalho);

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletartrabalho(@PathVariable Long id);

}
