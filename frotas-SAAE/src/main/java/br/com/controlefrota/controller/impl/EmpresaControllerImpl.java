package br.com.controlefrota.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.com.controlefrota.domain.model.EmpresaModel;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefrota.controller.EmpresaController;
import br.com.controlefrota.model.Empresa;
import br.com.controlefrota.repository.EmpresaRepository;
import br.com.controlefrota.service.impl.EmpresaServiceEJB;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class EmpresaControllerImpl implements EmpresaController{

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	EmpresaServiceEJB empresaService;

	@Override
	public List<EmpresaModel> listaEmpresas() {
		return empresaService.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<?> listaUnicoEmpresaPorId(@PathVariable Long id) {
		try {
			return new ResponseEntity<Empresa>(empresaService.findById(id), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! "+e);
		}	
	}
	@Override
	public ResponseEntity<?> listaUnicoEmpresaPorCNPJ(@PathVariable(value="cnpj") String cnpj) {
		try {
			return new ResponseEntity<Empresa>(empresaService.findByCNPJ(cnpj), HttpStatus.OK);
		}catch(ServiceException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found! "+e);
		}
		
	}

	@Override
	public ResponseEntity<?> salvaEmpresa(@RequestBody Empresa empresa) {
		try {
		
			empresaService.cadastrarEmpresa(empresa);
			return ResponseEntity.status(HttpStatus.OK).body("Empresa cadastrada com sucesso");
		}catch(HttpClientErrorException a){

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Por favor Insira um CEP válido!");
		} catch (NullPointerException n) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar empresa!" + n);
		} catch (ServiceException e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar empresa!" + e);
		}
	}

	@Override
	public ResponseEntity<?> atualizarEmpresa(@RequestBody Empresa empresa) {
		
			empresaRepository.save(empresa);
			return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso.");
		
	}

	@Override
	public void deletarEmpresa(@PathVariable(value = "id") Long id) {
		empresaService.delete(id);
	}

	public EmpresaModel toDto(Empresa entity) {
		EmpresaModel dto = new EmpresaModel();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setCNPJ(entity.getCNPJ());
		dto.setEmail(entity.getEmail());
		dto.setTelefone(entity.getTelefone());
		dto.setComplemento(entity.getComplemento());
		dto.setNumero(entity.getNumero());
		dto.setCep(entity.getCep());
		return dto;
	}

}
