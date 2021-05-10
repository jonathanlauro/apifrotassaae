package br.com.controlefrota.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.CombustivelModel;
import br.com.controlefrota.model.CondutorModel;
import br.com.controlefrota.model.ConsumoModel;
import br.com.controlefrota.model.VeiculoModel;
import br.com.controlefrota.repository.CombustivelRepository;
import br.com.controlefrota.repository.CondutorRepository;
import br.com.controlefrota.repository.ConsumoRepository;
import br.com.controlefrota.repository.VeiculoRepository;

@Service
public class ConsumoService {

	@Autowired
	ConsumoRepository consumoRepository;
	@Autowired
	VeiculoRepository veiculoRepository;
	@Autowired
	CondutorRepository condutorRepository;
	@Autowired
	CombustivelRepository combustivelRepository;
	
	public void criar(ConsumoModel consumo) {
		CondutorModel condutor = condutorRepository.findById(Long.valueOf(consumo.getCondutor().getId()).longValue());
		VeiculoModel veiculo = veiculoRepository.findByPlaca(consumo.getVeiculo().getPlaca());
		CombustivelModel combustivel = combustivelRepository.findById(Long.valueOf(consumo.getCombustivel().getId()).longValue());
		
		consumo.setCombustivel(combustivel);
		consumo.setCondutor(condutor);
		consumo.setVeiculo(veiculo);
		consumo.setDataDeCriacao(LocalDate.now());
		
		consumoRepository.save(consumo);
	}
}
