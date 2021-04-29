package br.com.controlefrota.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.controlefrota.model.Empresa;
import br.com.controlefrota.repository.EmpresaRepository;
import br.com.controlefrota.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	EmpresaService empresaService;

	@GetMapping
	public List<Empresa> listaEmpresas() {
		return empresaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Empresa> listaUnicoEmpresaPorId(@PathVariable Long id) {
		return empresaRepository.findById(id);
	}

	@PostMapping
	public ResponseEntity<?> salvaEmpresa(@RequestBody Empresa empresa) {
		try {
			empresaService.cadastrarEmpresa(empresa);
			return ResponseEntity.status(HttpStatus.OK).body("Empresa cadastrada com sucesso");
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar empresa!");
		}
	}

	@PatchMapping
	public ResponseEntity<?> atualizarEmpresa(@RequestBody Empresa empresa) {
		
			empresaRepository.save(empresa);
			return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso.");
		
	}

	@DeleteMapping("/{id}")
	public void deletarEmpresa(@PathVariable(value = "id") Long id) {
		empresaRepository.deleteById(id);
	}

}
