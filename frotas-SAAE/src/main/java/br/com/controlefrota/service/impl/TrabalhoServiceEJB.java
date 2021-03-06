package br.com.controlefrota.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.controlefrota.domain.model.TrabalhoModel;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.model.Trabalho;
import br.com.controlefrota.model.Veiculo;
import br.com.controlefrota.repository.CondutorRepository;
import br.com.controlefrota.repository.TrabalhoRepository;
import br.com.controlefrota.repository.VeiculoRepository;
import br.com.controlefrota.service.CadastroDeTrablho;

@Service
public class TrabalhoServiceEJB implements CadastroDeTrablho {

	@Autowired
	TrabalhoRepository trabalhoRepository;
	@Autowired
	CondutorRepository condutorRepository;
	@Autowired
	VeiculoRepository veiculoRepository;

	@Override
	public Trabalho criar(Trabalho trabalho) {
		Condutor condutor = condutorRepository.findBycnh(trabalho.getCondutor().getCnh());
		Veiculo veiculo = veiculoRepository.findByPlaca(trabalho.getVeiculo().getPlaca());

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado!");
		}
		if (condutor == null) {
			throw new ServiceException("Condutor não encontrado!");
		}

		if (condutor.getStatus().equals("Em_trabalho") || veiculo.getStatus().equals("Ocupado")) {
			if (condutor.getStatus().equals("Em_trabalho")) {
				throw new ServiceException("Condutor em trabalho ativo");
			} else {
				throw new ServiceException("Veículo em trabalho ativo");
			}

		}
		trabalho.setKmInicial(veiculo.getKm());
		trabalho.setCondutor(condutor);
		trabalho.setVeiculo(veiculo);
		trabalho.setDataInicioVigencia(LocalDate.now());
		trabalho.setDataDeCriacao(LocalDate.now());
		veiculo.setStatus("Ocupado");
		condutor.setStatus("Em_trabalho");

		return trabalhoRepository.save(trabalho);
	}

	@Override
	public Trabalho findById(long id) {
		Trabalho trabalho = trabalhoRepository.findById(id);

		if (trabalho == null) {
			throw new ServiceException("Trabalho não encontrado.");
		}
		return trabalho;
	}

	@Override
	public void encerrarTrabalho(long idTrabalho, String KmFinal) {
		Trabalho trabalho = trabalhoRepository.findById(idTrabalho);
		Condutor condutor = condutorRepository.findBycnh(trabalho.getCondutor().getCnh());
		Veiculo veiculo = veiculoRepository.findByPlaca(trabalho.getVeiculo().getPlaca());

		if (trabalho.getStatusTrabalho().equals("Encerrado")) {
			throw new ServiceException("Trabalho já foi encerrado!");
		}
		if (trabalho == null) {
			throw new ServiceException("Trabalho não encontrado");
		}
		if (condutor == null) {

			throw new ServiceException("Trabalho não encontrado");
		}
		if (veiculo == null) {

			throw new ServiceException("Trabalho não encontrado");
		}

		condutor.setStatus("Disponivel");
		veiculo.setStatus("Disponivel");
		veiculo.setKm(KmFinal);
		trabalho.setDataFimVigencia(LocalDate.now());
		trabalho.setStatusTrabalho("Encerrado");
		trabalho.setKmFinal(KmFinal);

		condutorRepository.save(condutor);
		veiculoRepository.save(veiculo);
		trabalhoRepository.save(trabalho);
	}

	@Override
	public void deletar(long id) {
		
		Trabalho trabalho = trabalhoRepository.findById(id);

		if (trabalho == null) {
			throw new ServiceException("Trabalho não encontrado.");
		}
		if (trabalho.getDeleted() == null) {
			throw new ServiceException("Este trabalho ja foi deletado.");
		}
		if (trabalho.getStatusTrabalho().equals("Em_vigencia")) {
			throw new ServiceException("Este trabalho não pode ser deletado pois está em vigência.");
		}
		
		trabalho.setDeleted(LocalDate.now());
		trabalhoRepository.save(trabalho);
	}

	@Override
	public List<TrabalhoModel> findAll() {
		List<TrabalhoModel> listaDeTrabalhos = trabalhoRepository.findByDeleted(null).stream().map(this::toDto).collect(Collectors.toList());

		Collections.sort(listaDeTrabalhos);

		return listaDeTrabalhos;
	}

	public TrabalhoModel toDto(Trabalho entity) {
		TrabalhoModel dto = new TrabalhoModel();
		dto.setIdTrabalho(entity.getIdTrabalho());
		dto.setVeiculo(entity.getVeiculo().getModelo());
		dto.setCondutor(entity.getCondutor().getNome());
		dto.setDataInicio(entity.getDataInicioVigencia());
		dto.setIdConduto(entity.getCondutor().getId());
		dto.setPlaca(entity.getVeiculo().getPlaca());
		dto.setDataFim(entity.getDataFimVigencia());
		dto.setApelidoVeiculo(entity.getVeiculo().getApelido());
		dto.setStatusTrabalho(entity.getStatusTrabalho());
		dto.setDataDeCriacao(entity.getDataDeCriacao());
		return dto;
	}

}
