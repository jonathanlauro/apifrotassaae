package br.com.controlefrota.service;

import java.time.LocalDate;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.repository.CondutorRepository;

@Service
public class CondutorService {

	@Autowired
	CondutorRepository condutorRepository;
	
	public Condutor criar(Condutor condutor) {
		Condutor condutorA = condutorRepository.findByCNH(condutor.getCNH());
		if(condutorA != null) {
			throw new ServiceException("Condutor já cadastrado no sistema!");
		}
		if(condutor.getNome() == null || condutor.getCPF() == null || condutor.getCNH() == null) {
			throw new ServiceException("Por favor, preencha todos os campos");
		}
		if(condutor.getCPF().equals("00000000000") || condutor.getCPF().equals("11111111111")||
				condutor.getCPF().equals("22222222222") || condutor.getCPF().equals("33333333333")||
				condutor.getCPF().equals("44444444444") || condutor.getCPF().equals("55555555555") ||
				condutor.getCPF().equals("66666666666") || condutor.getCPF().equals("77777777777") ||
				condutor.getCPF().equals("88888888888") || condutor.getCPF().equals("99999999999") ||
				condutor.getCPF().length() != 11) {
			
			throw new ServiceException("CPF inválido");
		}
		if(condutor.getCNH().equals("00000000000") || condutor.getCNH().equals("11111111111")||
				condutor.getCNH().equals("22222222222") || condutor.getCNH().equals("33333333333")||
				condutor.getCNH().equals("44444444444") || condutor.getCNH().equals("55555555555") ||
				condutor.getCNH().equals("66666666666") || condutor.getCNH().equals("77777777777") ||
				condutor.getCNH().equals("88888888888") || condutor.getCNH().equals("99999999999") ||
				condutor.getCNH().length() != 11) {
			
			throw new ServiceException("CNH inválido");
		}
		condutor.setDataDeCriacao(LocalDate.now());
			return condutorRepository.save(condutor);
		
	}
	public Condutor findById(long id) {
		Condutor condutor = condutorRepository.findById(id);
		
		if(condutor == null) {
			throw new ServiceException("condutor não encontrado");
		}
			return condutor;
		
	}
	public Condutor findByCnh(String cnh) {
			Condutor condutor = condutorRepository.findByCNH(cnh);
		
		if(condutor == null) {
			throw new ServiceException("condutor não encontrado");
		}
			return condutor;
	}
	
	public void deletar(long id) {
		Condutor condutor = condutorRepository.findById(id);
		
		if(condutor.getStatus().equals("Em_trabalho")) {
			throw new ServiceException("Condutor não pode ser excluido pois está em trabalho.");
		}else {
			condutorRepository.deleteById(condutor.getId());
		}
	}
}
