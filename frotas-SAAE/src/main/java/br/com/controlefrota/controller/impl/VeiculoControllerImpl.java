package br.com.controlefrota.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.controller.VeiculoController;
import br.com.controlefrota.domain.model.VeiculoModel;
import br.com.controlefrota.model.Veiculo;
import br.com.controlefrota.repository.VeiculoRepository;
import br.com.controlefrota.service.impl.VeiculoServiceEJB;

@RestController
public class VeiculoControllerImpl implements VeiculoController {

	@Autowired
	VeiculoRepository veiculoRepository;

	@Autowired
	VeiculoServiceEJB veiculoService;

	

	@Override
	public List<VeiculoModel> listarVeiculos() {
		return veiculoService.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<?> procurarPorId(@PathVariable(value = "id") long id) {
		try {
			return new ResponseEntity<Veiculo>(veiculoService.findById(id), HttpStatus.OK);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! " + e);
		}
	}

	@Override
	public ResponseEntity<?> procurarPorPlaca(@PathVariable String placa) {
		try {
			return new ResponseEntity<Veiculo>(veiculoService.findByPlaca(placa), HttpStatus.OK);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! " + e);
		}
	}

	@Override
	public ResponseEntity<?> procurarPorRenavam(@PathVariable String renavam) {
		try {
			return new ResponseEntity<Veiculo>(veiculoService.findByPlaca(renavam), HttpStatus.OK);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! " + e);
		}
	}

	@Override
	public ResponseEntity<?> atualizarVeiculo(@RequestBody Veiculo veiculo) {

		veiculoRepository.save(veiculo);
		return ResponseEntity.status(HttpStatus.OK).body("Veículo alterado com sucesso!");
	}

	@Override
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculo veiculo) throws Exception {
		try {

			veiculoService.criar(veiculo);
			return ResponseEntity.status(HttpStatus.OK).body("Veículo cadastrado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar! " + e);
		}
	}

	@Override
	public ResponseEntity<?> deletarVeiculo(@PathVariable long id) {

		try {
			veiculoService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Veículo deletado com sucesso!");
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar veículo! " + e);
		}

	}
	
	public VeiculoModel toDto(Veiculo entity) {
        VeiculoModel dto = new VeiculoModel();
        dto.setId(entity.getIdVeiculo());
        dto.setModelo(entity.getModelo());
        dto.setPlaca(entity.getPlaca());
        dto.setRenavam(entity.getRenavam());
        dto.setStatus(entity.getStatus());
        return dto;
    }

}
