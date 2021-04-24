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

import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.model.Trabalho;
import br.com.controlefrota.repository.ConsumoRepository;

@RestController
@RequestMapping("/consumos")
public class ConsumoController {

	ConsumoRepository consumoRepository;

	@GetMapping
	public List<Consumo> listatrabalhos() {
		return consumoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Consumo> listaUnicotrabalhoPorId(@PathVariable Long id) {
		return consumoRepository.findById(id);
	}

	@PostMapping
	public Consumo salvatrabalho(@RequestBody Consumo consumo) {
		return consumoRepository.save(consumo);
	}

	@PatchMapping
	public Consumo atualizartrabalho(@RequestBody Consumo consumo) {
		return consumoRepository.save(consumo);
	}

	@DeleteMapping("/{id}")
	public void deletartrabalho(@PathVariable Long id) {
		consumoRepository.deleteById(id);
	}
}
