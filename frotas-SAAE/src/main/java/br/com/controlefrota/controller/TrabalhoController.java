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

import br.com.controlefrota.domain.model.ErroModelo;
import br.com.controlefrota.domain.model.TrabalhoModel;
import br.com.controlefrota.model.Trabalho;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/trabalhos")
@Api(value = "API REST Trabalho", tags = "Trabalho")
@CrossOrigin(origins = "*")
public interface TrabalhoController {

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de Trabalho")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Lista de Trabalhos", response = TrabalhoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public List<TrabalhoModel> listatrabalhos();

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma unico Trabalho")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "SUCCESS", response = TrabalhoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Trabalho não Encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> listaUnicotrabalhoPorId(@PathVariable(value = "id") long id);

	@PostMapping
	@ApiOperation(value = "Registra uma Trabalho")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Trabalho registrado com sucesso", response = TrabalhoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> salvatrabalho(@RequestBody Trabalho trabalho);

	@GetMapping("/encerrarTrabalho/{idTrabalho}/{kmFinal}")
	@ApiOperation(value = "Encerra um Trabalho")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Trabalho encerrado com sucesso", response = TrabalhoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Trabalho não Encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> encerrarTrabalho(@PathVariable(value = "idTrabalho") Long id,
			@PathVariable(value = "kmFinal") String kmFinal);

	@GetMapping("/{status}/status-trabalho")
	@ApiOperation(value = "Retorna uma lista de Trabalho")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Lista de trabalhos", response = TrabalhoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Trabalho não Encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public List<Trabalho> listarPorStatus(@PathVariable(value = "status") String status);

	@PatchMapping
	@ApiOperation(value = "Atualiza uma Trabalho")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Trabalho atualizado com sucesso", response = TrabalhoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Trabalho não Encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public Trabalho atualizartrabalho(@RequestBody Trabalho trabalho);

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma Trabalho")
	@ApiResponses( value = {
		@ApiResponse(code = 200, message = "Trabalho deletado com sucesso", response = TrabalhoModel.class),
		@ApiResponse(code = 401, message = "Toke Inválido", response = ErroModelo.class),
		@ApiResponse(code = 404, message = "Trabalho não Encontrado", response = ErroModelo.class),
		@ApiResponse(code = 500, message = "Erro interno no sistema", response = ErroModelo.class),
	})
	public ResponseEntity<?> deletartrabalho(@PathVariable Long id);

}
