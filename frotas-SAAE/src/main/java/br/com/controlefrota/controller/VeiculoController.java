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

import br.com.controlefrota.model.Veiculo;
import br.com.controlefrota.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	VeiculoRepository veiculoRepository;

	@GetMapping
	public List<Veiculo> listarVeiculos() {
		return veiculoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Veiculo> procurarPorId(@PathVariable Long id) {
		return veiculoRepository.findById(id);
	}

	@GetMapping("/{placa}")
	public Veiculo procurarPorPlaca(@PathVariable String placa) {
		return veiculoRepository.findByPlaca(placa);
	}

	@GetMapping("/{renavam}")
	public Veiculo procurarPorRenavam(@PathVariable String renavam) {
		return veiculoRepository.findByRenavam(renavam);
	}

	@PatchMapping
	public ResponseEntity<?> atualizarVeiculo(@RequestBody Veiculo veiculo) {

		veiculoRepository.save(veiculo);
		return ResponseEntity.status(HttpStatus.OK).body("Veículo alterado com sucesso!");
	}

	@PostMapping
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculo veiculo) {

		veiculoRepository.save(veiculo);
		return ResponseEntity.status(HttpStatus.OK).body("Veículo cadastrado com sucesso!");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarVeiculo(@PathVariable Long id) {

		return ResponseEntity.status(HttpStatus.OK).body("Veículo deletado com sucesso!");
	}

}
