package br.com.controlefrota.service;

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
	
	public Consumo criar(Consumo consumo) {
		Condutor condutor = condutorRepository.findById(Long.valueOf(consumo.getCondutor().getId()).longValue());
		Veiculo veiculo = veiculoRepository.findByPlaca(consumo.getVeiculo().getPlaca());
		Combustivel combustivel = combustivelRepository.findById(Long.valueOf(consumo.getCombustivel().getId()).longValue());
		
		consumo.setCombustivel(combustivel);
		consumo.setCondutor(condutor);
		consumo.setVeiculo(veiculo);
		
		return consumoRepository.save(consumo);
	}
}
