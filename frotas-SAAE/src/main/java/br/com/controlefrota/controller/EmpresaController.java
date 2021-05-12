package br.com.controlefrota.controller;

import java.util.List;

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

import br.com.controlefrota.model.EmpresaModel;
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
	public List<EmpresaModel> listaEmpresas() {
		return empresaService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listaUnicoEmpresaPorId(@PathVariable Long id) {
		try {
			return new ResponseEntity<EmpresaModel>(empresaService.findById(id), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! "+e);
		}	
	}
	@GetMapping("/{cnpj}/cnpj")
	public ResponseEntity<?> listaUnicoEmpresaPorCNPJ(@PathVariable(value="cnpj") String cnpj) {
		try {
			return new ResponseEntity<EmpresaModel>(empresaService.findByCNPJ(cnpj), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! "+e);
		}
		
	}

	@PostMapping
	public ResponseEntity<?> salvaEmpresa(@RequestBody EmpresaModel empresa) {
		try {
		
			empresaService.cadastrarEmpresa(empresa);
			return ResponseEntity.status(HttpStatus.OK).body("Empresa cadastrada com sucesso");
		} catch (NullPointerException n) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar empresa!" + n);
		} catch (ServiceException e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar empresa!" + e);
		}
	}

	@PatchMapping
	public ResponseEntity<?> atualizarEmpresa(@RequestBody EmpresaModel empresa) {
		
			empresaRepository.save(empresa);
			return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso.");
		
	}

	@DeleteMapping("/{id}")
	public void deletarEmpresa(@PathVariable(value = "id") Long id) {
		empresaService.delete(id);
	}

}
