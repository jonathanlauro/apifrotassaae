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

import br.com.controlefrota.model.VeiculoModel;
import br.com.controlefrota.repository.VeiculoRepository;
import br.com.controlefrota.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	VeiculoService veiculoService;

	@GetMapping
	public List<VeiculoModel> listarVeiculos() {
		return veiculoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> procurarPorId(@PathVariable(value="id") long id) {
		try {
			return new ResponseEntity<VeiculoModel>(veiculoService.findById(id), HttpStatus.OK);
		}catch(ServiceException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! "+ e);
		}
	}

	@GetMapping("/{placa}/placa")
	public ResponseEntity<?> procurarPorPlaca(@PathVariable String placa) {
		try {
			return new ResponseEntity<VeiculoModel>(veiculoService.findByPlaca(placa), HttpStatus.OK);
		}catch(ServiceException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! "+ e);
		}
	}
 
	@GetMapping("/{renavam}/renavam")
	public ResponseEntity<?> procurarPorRenavam(@PathVariable String renavam) {
		try {
			return new ResponseEntity<VeiculoModel>(veiculoService.findByPlaca(renavam), HttpStatus.OK);
		}catch(ServiceException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! "+ e);
		}
	}

	@PatchMapping
	public ResponseEntity<?> atualizarVeiculo(@RequestBody VeiculoModel veiculo) {

		veiculoRepository.save(veiculo);
		return ResponseEntity.status(HttpStatus.OK).body("Veículo alterado com sucesso!");
	}

	@PostMapping
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody VeiculoModel veiculo) throws Exception {
		try {
			
			veiculoService.criar(veiculo);
			return ResponseEntity.status(HttpStatus.OK).body("Veículo cadastrado com sucesso!");
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar! "+e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarVeiculo(@PathVariable long id) {
		
		try {
			veiculoService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Veículo deletado com sucesso!");
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar veículo! "+ e);
		}

	}

}
