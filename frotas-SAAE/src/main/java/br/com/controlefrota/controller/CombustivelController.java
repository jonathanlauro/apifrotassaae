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

import br.com.controlefrota.model.Combustivel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/combustivel")
@Api(value = "API REST Combustivel", tags = "Combustivel")
@CrossOrigin(origins = "*")
public interface CombustivelController {

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de combustivel")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Combustivel.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public List<Combustivel> listaCombustivel();
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um único tipo de combustivel")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "SUCCESS", response = Combustivel.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED"),
			@ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"),
		})
	public ResponseEntity<?> listaUnicoCombustivel(@PathVariable(value="id") long id );
	
	@PostMapping
	@ApiOperation(value = "Cadastra um combustivel")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "SUCCESS", response = Combustivel.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED"),
			@ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"),
		})
	public ResponseEntity<?> cadastraCombustivel(@RequestBody Combustivel combustivel );
	
	@PatchMapping
	@ApiOperation(value = "Atualiza um combustivel")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "SUCCESS", response = Combustivel.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED"),
			@ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"),
		})
	public Combustivel updateCombustivel(@RequestBody Combustivel combustivel );
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um combustivel")
	@ApiResponses( value = {
			@ApiResponse(code = 200, message = "SUCCESS", response = Combustivel.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED"),
			@ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"),
		})
	public void deleteCombustivel(@PathVariable(value="id") Long id );
}
