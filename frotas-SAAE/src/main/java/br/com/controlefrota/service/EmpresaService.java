package br.com.controlefrota.service;

import java.time.LocalDate;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.EmpresaModel;
import br.com.controlefrota.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	EmpresaRepository empresaRepository;

	public EmpresaModel cadastrarEmpresa(EmpresaModel empresa) {
		

		
		
		if(empresa.getCNPJ().equals("00000000000000") || empresa.getCNPJ().equals("11111111111111")||
				empresa.getCNPJ().equals("22222222222222") || empresa.getCNPJ().equals("33333333333333")||
				empresa.getCNPJ().equals("44444444444444") || empresa.getCNPJ().equals("55555555555555") ||
				empresa.getCNPJ().equals("66666666666666") || empresa.getCNPJ().equals("77777777777777") ||
				empresa.getCNPJ().equals("88888888888888") || empresa.getCNPJ().equals("99999999999999") ||
				empresa.getCNPJ().length() != 14) {
			
			throw new ServiceException("CNPJ inválido");
		}
		empresa.setDataDeCriacao(LocalDate.now());
		return empresaRepository.save(empresa);
	}
	public EmpresaModel findById(long id) {
		EmpresaModel empresa = empresaRepository.findById(id);
		
		if(empresa == null) {
			throw new ServiceException("Empresa não encontrada.");
		}
		
		return empresa;
	}
	public EmpresaModel findByCNPJ(String cnpj) {
		EmpresaModel empresa = empresaRepository.findByCNPJ(cnpj);
		
		if(empresa == null) {
			throw new ServiceException("Empresa não encontrada.");
		}
		
		return empresa;
	}

}
