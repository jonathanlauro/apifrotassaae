package br.com.controlefrota.controller;

import java.util.List;

import br.com.controlefrota.domain.model.EmpresaModel;
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

import br.com.controlefrota.domain.model.ErroModelo;
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
		@ApiResponse(code = 200, message = "Lista de empresas", response = Empresa.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public List<EmpresaModel> listaEmpresas();
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma unica empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Empresa", response = Empresa.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Empresa não encontrada", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> listaUnicoEmpresaPorId(@PathVariable Long id);
	
	@GetMapping("/{cnpj}/cnpj")
	@ApiOperation(value = "Retorna uma unica empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Empresa", response = Empresa.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Empresa não encontrada", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> listaUnicoEmpresaPorCNPJ(@PathVariable(value="cnpj") String cnpj);
	
	@PostMapping
	@ApiOperation(value = "Registra uma empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Empresa Registrada", response = Empresa.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> salvaEmpresa(@RequestBody Empresa empresa);
	
	@PatchMapping
	@ApiOperation(value = "Atualiza uma empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Empresa atualizada", response = Empresa.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Empresa não encontrada", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> atualizarEmpresa(@RequestBody Empresa empresa);
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma empresa")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Deletado com sucesso", response = Empresa.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Empresa não encontrada", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public void deletarEmpresa(@PathVariable(value = "id") Long id);
}
