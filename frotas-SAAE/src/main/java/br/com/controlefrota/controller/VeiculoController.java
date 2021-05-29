package br.com.controlefrota.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/veiculos")
@Api(value = "API REST Veiculo", tags = "Veiculo")
@CrossOrigin(origins = "*")
public interface VeiculoController {

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de Veiculo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = VeiculoModel.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public List<VeiculoModel> listarVeiculos();

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um unico Veiculo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = VeiculoModel.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> procurarPorId(@PathVariable(value = "id") long id);

	@GetMapping("/{placa}/placa")
	@ApiOperation(value = "Retorna um unico Veiculo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = VeiculoModel.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> procurarPorPlaca(@PathVariable String placa);

	@GetMapping("/{renavam}/renavam")
	@ApiOperation(value = "Retorna um unico Veiculo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = VeiculoModel.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> procurarPorRenavam(@PathVariable String renavam);

	@PatchMapping
	@ApiOperation(value = "Atualiza um Veiculo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = VeiculoModel.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> atualizarVeiculo(@RequestBody Veiculo veiculo);

	@PostMapping
	@ApiOperation(value = "Cadastrar um unico Veiculo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = VeiculoModel.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculo veiculo) throws Exception;

	@DeleteMapping("/{id}")
	@ApiOperation(value = "DEletar um Veiculo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = VeiculoModel.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> deletarVeiculo(@PathVariable long id);
}
