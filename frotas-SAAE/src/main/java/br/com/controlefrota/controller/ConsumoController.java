package br.com.controlefrota.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.model.Consumo;
@RestController
@RequestMapping("/consumos")
public interface ConsumoController {

	@GetMapping
	public List<ConsumoModel> listaConsumos();
	@GetMapping("/{id}")
	public Optional<Consumo> listaUnicoConsumoPorId(@PathVariable(value="id") Long id);
	@PostMapping
	public ResponseEntity<?> salvaconsumo(@RequestBody Consumo consumo);
	@PatchMapping
	public Consumo atualizarConsumo(@RequestBody Consumo consumo);
	@DeleteMapping("/{id}")
	public void deletarconsumo(@PathVariable Long id);
}
