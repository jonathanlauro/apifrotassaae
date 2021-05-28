package br.com.controlefrota.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.repository.CondutorRepository;
import br.com.controlefrota.service.CadastroDeCondutor;

@Service
public class CondutorServiceEJB implements CadastroDeCondutor {

	@Autowired
	CondutorRepository condutorRepository;
	
	@Override
	public Condutor criar(Condutor condutor) {
		Condutor condutorA = condutorRepository.findByCNH(condutor.getCNH());
		if (condutor.getNome() == null || condutor.getCPF() == null || condutor.getCNH() == null) {
			throw new ServiceException("Por favor, preencha todos os campos");
		}
		if (condutorA != null && condutorA.isDeleted() == false) {
			throw new ServiceException("Condutor já cadastrado no sistema!");
		}

		if (condutorA != null && condutorA.getCPF().equals(condutor.getCPF())) {
			condutor.setId(condutorA.getId());
			condutor.setDeleted(false);
			condutor.setDataDeCriacao(LocalDate.now());
			condutor.setStatus("Disponivel");
			return condutorRepository.save(condutor);
		} else {

			if (condutor.getCPF().equals("00000000000") || condutor.getCPF().equals("11111111111")
					|| condutor.getCPF().equals("22222222222") || condutor.getCPF().equals("33333333333")
					|| condutor.getCPF().equals("44444444444") || condutor.getCPF().equals("55555555555")
					|| condutor.getCPF().equals("66666666666") || condutor.getCPF().equals("77777777777")
					|| condutor.getCPF().equals("88888888888") || condutor.getCPF().equals("99999999999")
					|| condutor.getCPF().length() != 11) {

				throw new ServiceException("CPF inválido");
			}

			if (condutor.getCNH().equals("00000000000") || condutor.getCNH().equals("11111111111")
					|| condutor.getCNH().equals("22222222222") || condutor.getCNH().equals("33333333333")
					|| condutor.getCNH().equals("44444444444") || condutor.getCNH().equals("55555555555")
					|| condutor.getCNH().equals("66666666666") || condutor.getCNH().equals("77777777777")
					|| condutor.getCNH().equals("88888888888") || condutor.getCNH().equals("99999999999")
					|| condutor.getCNH().length() != 11) {

				throw new ServiceException("CNH inválido");
			}
			condutor.setDeleted(false);
			condutor.setDataDeCriacao(LocalDate.now());
			return condutorRepository.save(condutor);
		}

	}
	
	@Override
	public Condutor findById(long id) {
		Condutor condutor = condutorRepository.findById(id);

		if (condutor == null) {
			throw new ServiceException("condutor não encontrado");
		}
		return condutor;

	}
	
	@Override
	public Condutor findByCnh(String cnh) {
		Condutor condutor = condutorRepository.findByCNH(cnh);

		if (condutor == null) {
			throw new ServiceException("condutor não encontrado");
		}
		return condutor;
	}

	@Override
	public List<Condutor> findAll() {
		return condutorRepository.findByDeleted(false);
	}

	@Override
	public void deletar(long id) {
		Condutor condutor = condutorRepository.findById(id);

		if (condutor.getStatus().equals("Em_trabalho")) {
			throw new ServiceException("Condutor não pode ser excluido pois está em trabalho.");
		} else {
			condutor.setDeleted(true);
			condutorRepository.save(condutor);
		}
	}
}
