package br.com.controlefrota.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.CombustivelModel;
import br.com.controlefrota.repository.CombustivelRepository;

@Service
public class CombustivelService {

	@Autowired
	CombustivelRepository combustivelRepository;
	
	public CombustivelModel cadastrar(CombustivelModel combustivel) {
		
		if(combustivel.getNome() == null) {
			throw new ServiceException("Por favor, preencha todos os campos.");
		}
		return combustivelRepository.save(combustivel);
	}
	public CombustivelModel findById(long id) {
		CombustivelModel combustivel = combustivelRepository.findById(id);
		
		if(combustivel == null) {
			throw new ServiceException("Combustivel não encontrado.");
		}
		return combustivel;
	}
	
}
