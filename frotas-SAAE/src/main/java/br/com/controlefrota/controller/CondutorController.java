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

import br.com.controlefrota.model.Condutor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/condutores")
@Api(value = "API REST Condutor", tags = "Condutor")
@CrossOrigin(origins = "*")
public interface CondutorController {

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um unico condutores")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Condutor.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> listaUnicoCondutorPorId(@PathVariable(value = "id") long id);
	
	@ApiOperation(value = "Retorna uma lista de condutores")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Condutor.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public List<Condutor> listaCondutor();
	
	@GetMapping("/{cnh}/cnh")
	@ApiOperation(value = "Retorna um unico condutores")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Condutor.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> listaUnicoCondutorPorCNH(@PathVariable(value = "cnh") String cnh);
	
	@PostMapping
	@ApiOperation(value = "Cadastra um condutor")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Condutor.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> salvaCondutor(@RequestBody Condutor condutor);
	
	@PatchMapping
	@ApiOperation(value = "Atualiza um unico condutores")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Condutor.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public Condutor atualizarCondutor(@RequestBody Condutor condutor);
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um unico condutores")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Condutor.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> deletarCondutor(@PathVariable(value = "id") long id);
	
	
}
