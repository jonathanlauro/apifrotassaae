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
		Condutor condutorA = condutorRepository.findBycnh(condutor.getCnh());
		if (condutor.getNome() == null || condutor.getCpf() == null || condutor.getCnh() == null) {
			throw new ServiceException("Por favor, preencha todos os campos");
		}
		if (condutorA != null && condutorA.getDeleted() != null ) {
			throw new ServiceException("Condutor já cadastrado no sistema!");
		}

		if (condutorA != null && condutorA.getCpf().equals(condutor.getCpf())) {
			condutor.setId(condutorA.getId());
			condutor.setDataDeCriacao(LocalDate.now());
			condutor.setStatus("Disponivel");
			return condutorRepository.save(condutor);
		} else {

			if (condutor.getCpf().equals("00000000000") || condutor.getCpf().equals("11111111111")
					|| condutor.getCpf().equals("22222222222") || condutor.getCpf().equals("33333333333")
					|| condutor.getCpf().equals("44444444444") || condutor.getCpf().equals("55555555555")
					|| condutor.getCpf().equals("66666666666") || condutor.getCpf().equals("77777777777")
					|| condutor.getCpf().equals("88888888888") || condutor.getCpf().equals("99999999999")
					|| condutor.getCpf().length() != 11) {

				throw new ServiceException("CPF inválido");
			}

			if (condutor.getCnh().equals("00000000000") || condutor.getCnh().equals("11111111111")
					|| condutor.getCnh().equals("22222222222") || condutor.getCnh().equals("33333333333")
					|| condutor.getCnh().equals("44444444444") || condutor.getCnh().equals("55555555555")
					|| condutor.getCnh().equals("66666666666") || condutor.getCnh().equals("77777777777")
					|| condutor.getCnh().equals("88888888888") || condutor.getCnh().equals("99999999999")
					|| condutor.getCnh().length() != 11) {

				throw new ServiceException("CNH inválido");
			}
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
		Condutor condutor = condutorRepository.findBycnh(cnh);

		if (condutor == null) {
			throw new ServiceException("condutor não encontrado");
		}
		return condutor;
	}

	@Override
	public List<Condutor> findAll() {
		return condutorRepository.findByDeleted(null);
	}

	@Override
	public void deletar(long id) {
		Condutor condutor = condutorRepository.findById(id);

		if (condutor.getStatus().equals("Em_trabalho")) {
			throw new ServiceException("Condutor não pode ser excluido pois está em trabalho.");
		} else {
			condutor.setDeleted(LocalDate.now());
			condutorRepository.save(condutor);
		}
	}
}
