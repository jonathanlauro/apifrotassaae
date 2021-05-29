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

import br.com.controlefrota.model.Empresa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/empresas")
@Api(value = "API REST Empresa", tags = "Empresa")
@CrossOrigin(origins = "*")
public interface EmpresaController {

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de empresas")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Empresa.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public List<Empresa> listaEmpresas();
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma unica empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Empresa.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> listaUnicoEmpresaPorId(@PathVariable Long id);
	
	@GetMapping("/{cnpj}/cnpj")
	@ApiOperation(value = "Retorna uma unica empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Empresa.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> listaUnicoEmpresaPorCNPJ(@PathVariable(value="cnpj") String cnpj);
	
	@PostMapping
	@ApiOperation(value = "Registra uma empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Empresa.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> salvaEmpresa(@RequestBody Empresa empresa);
	
	@PatchMapping
	@ApiOperation(value = "Atualiza uma empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Empresa.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public ResponseEntity<?> atualizarEmpresa(@RequestBody Empresa empresa);
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = Empresa.class),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 403, message = "FORBIDDEN"),
		@ApiResponse(code = 404, message = "NOT FOUND"),
	})
	public void deletarEmpresa(@PathVariable(value = "id") Long id);
}
