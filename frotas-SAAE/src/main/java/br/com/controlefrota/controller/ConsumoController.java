package br.com.controlefrota.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.controlefrota.model.ConsumoModel;
import br.com.controlefrota.repository.ConsumoRepository;
import br.com.controlefrota.service.ConsumoService;

@RestController
@RequestMapping("/consumos")
public class ConsumoController {
	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	ConsumoService consumoService;

	@GetMapping
	public List<ConsumoModel> listaConsumos() {
		return consumoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<ConsumoModel> listaUnicoConsumoPorId(@PathVariable(value="id") Long id) {
		return consumoRepository.findById(id);
	}

	@PostMapping
	public ResponseEntity<?> salvaconsumo(@RequestBody ConsumoModel consumo) {
			try {
				
				consumoService.criar(consumo);
				return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com sucesso");
			}catch( Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro! "+e);
			}
	
	}

	@PatchMapping
	public ConsumoModel atualizarConsumo(@RequestBody ConsumoModel consumo) {
		return consumoRepository.save(consumo);
	}

	@DeleteMapping("/{id}")
	public void deletarconsumo(@PathVariable Long id) {
		consumoRepository.deleteById(id);
	}
}
