package br.com.controlefrota.controller;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

	TrabalhoRepository trabalhoRepository;

	@GetMapping
	public List<Trabalho> listatrabalhos() {
		return trabalhoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Trabalho> listaUnicotrabalhoPorId(@PathVariable Long id) {
		return trabalhoRepository.findById(id);
	}

	@PostMapping
	public Trabalho salvatrabalho(@RequestBody Trabalho trabalho) {
		return trabalhoRepository.save(trabalho);
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
