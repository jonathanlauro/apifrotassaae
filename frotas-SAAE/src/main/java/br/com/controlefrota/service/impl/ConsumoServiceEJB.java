package br.com.controlefrota.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Combustivel;
import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.model.Consumo;
import br.com.controlefrota.model.Veiculo;
import br.com.controlefrota.repository.CombustivelRepository;
import br.com.controlefrota.repository.CondutorRepository;
import br.com.controlefrota.repository.ConsumoRepository;
import br.com.controlefrota.repository.VeiculoRepository;
import br.com.controlefrota.service.CadastroDeConsumo;

@Service
public class ConsumoServiceEJB implements CadastroDeConsumo {

	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	VeiculoRepository veiculoRepository;
	@Autowired
	CondutorRepository condutorRepository;
	@Autowired
	CombustivelRepository combustivelRepository;

	@Override
	public void criar(Consumo consumo) {
		Condutor condutor = condutorRepository.findById(Long.valueOf(consumo.getCondutor().getId()).longValue());
		Veiculo veiculo = veiculoRepository.findByPlaca(consumo.getVeiculo().getPlaca());
		Combustivel combustivel = combustivelRepository
				.findById(Long.valueOf(consumo.getCombustivel().getId()).longValue());

		consumo.setCombustivel(combustivel);
		consumo.setCondutor(condutor);
		consumo.setVeiculo(veiculo);
		consumo.setDataDeCriacao(LocalDate.now());
		consumo.setDeleted(false);

		consumoRepository.save(consumo);
	}

	@Override
	public void deletar(long id) {
		Consumo consumo = consumoRepository.findById(id);
		
		if(consumo == null) {
			throw new ServiceException("Esse consumo não existe");
		}
		consumo.setDeleted(true);
		
	}

	@Override
	public List<Consumo> findAll() {
	
		return consumoRepository.findByDeleted(false);
	}
}
