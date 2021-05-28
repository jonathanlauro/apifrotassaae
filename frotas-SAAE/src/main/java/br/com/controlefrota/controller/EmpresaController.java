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

import br.com.controlefrota.model.Empresa;

@RestController
@RequestMapping("/empresas")
public interface EmpresaController {

	@GetMapping
	public List<Empresa> listaEmpresas();
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listaUnicoEmpresaPorId(@PathVariable Long id);
	
	@GetMapping("/{cnpj}/cnpj")
	public ResponseEntity<?> listaUnicoEmpresaPorCNPJ(@PathVariable(value="cnpj") String cnpj);
	
	@PostMapping
	public ResponseEntity<?> salvaEmpresa(@RequestBody Empresa empresa);
	
	@PatchMapping
	public ResponseEntity<?> atualizarEmpresa(@RequestBody Empresa empresa);
	
	@DeleteMapping("/{id}")
	public void deletarEmpresa(@PathVariable(value = "id") Long id);
}
