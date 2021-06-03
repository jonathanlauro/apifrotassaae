package br.com.controlefrota.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.domain.model.ErroModelo;
import br.com.controlefrota.model.Combustivel;
import br.com.controlefrota.model.Consumo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/consumos")
@Api(value = "API REST Consumo", tags = "Consumos")
@CrossOrigin(origins = "*")
public interface ConsumoController {

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de consumos")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Lista de consumo", response = ConsumoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public List<ConsumoModel> listaConsumos();
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um unico consumo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Consumo", response = Consumo.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Consumo não encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public Optional<Consumo> listaUnicoConsumoPorId(@PathVariable(value="id") Long id);
	
	@GetMapping("/{NomeCombustivel}/COMBUSTIVEL")
	@ApiOperation(value = "Retorna um unico consumo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Consumo", response = Consumo.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Consumo não encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public List<ConsumoModel> listaUnicoConsumoPorCombustivel(
			@PathVariable(value="NomeCombustivel") String nome);
	
	@PostMapping
	@ApiOperation(value = "Registrar um consumo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Registrado com sucesso", response = ConsumoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> salvaconsumo(@RequestBody Consumo consumo);
	
	@PatchMapping
	@ApiOperation(value = "Atualizar um unico consumo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Consumo atualizado", response = ConsumoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Consumo não encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public Consumo atualizarConsumo(@RequestBody Consumo consumo);
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar um consumo")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Consumo atualizado", response = ConsumoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Consumo não encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> deletarconsumo(@PathVariable Long id);
}
