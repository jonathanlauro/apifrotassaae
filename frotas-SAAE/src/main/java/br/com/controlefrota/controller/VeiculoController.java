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

import br.com.controlefrota.domain.model.VeiculoModel;
import br.com.controlefrota.model.Veiculo;

@RestController
@RequestMapping("/veiculos")
public interface VeiculoController {

	@GetMapping
	public List<VeiculoModel> listarVeiculos();

	@GetMapping("/{id}")
	public ResponseEntity<?> procurarPorId(@PathVariable(value = "id") long id);

	@GetMapping("/{placa}/placa")
	public ResponseEntity<?> procurarPorPlaca(@PathVariable String placa);

	@GetMapping("/{renavam}/renavam")
	public ResponseEntity<?> procurarPorRenavam(@PathVariable String renavam);

	@PatchMapping
	public ResponseEntity<?> atualizarVeiculo(@RequestBody Veiculo veiculo);

	@PostMapping
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculo veiculo) throws Exception;

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarVeiculo(@PathVariable long id);
}
