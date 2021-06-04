package br.com.controlefrota.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.domain.model.ConsumoModel;
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
		
		if(condutor.getStatus().equals("Disponivel")) {
			throw new ServiceException("Só pode cadastrar consumo com condutor em status Em_trabalho");
		}
		if(veiculo.getStatus().equals("Disponivel")) {
			throw new ServiceException("Só pode cadastrar consumo co m veiculo com status Ocupado");
		}
		
		consumo.setCombustivel(combustivel);
		consumo.setCondutor(condutor);
		consumo.setVeiculo(veiculo);
		consumo.setDataDeCriacao(LocalDate.now());

		consumoRepository.save(consumo);
	}

	@Override
	public void deletar(long id) {
		Consumo consumo = consumoRepository.findById(id);
		
		if(consumo == null) {
			throw new ServiceException("Esse consumo não existe");
		}
		consumo.setDeleted(LocalDate.now());

		consumoRepository.save(consumo);
	}

	@Override
	public List<Consumo> findAll() {
	
		return consumoRepository.findByDeleted(null);
	}

	@Override
	public List<ConsumoModel> findbyCombustivel(String nome) {
		Combustivel combustivel = combustivelRepository.findBynome(nome);
		
		if(combustivel == null) {
			throw new ServiceException("Não existe esse combustivel");
		}
		
		List<Consumo> consumos = consumoRepository.findByCombustivel(combustivel);
		
		List<Consumo> consumos2 = new ArrayList<>();
		
		for (Consumo consumoModel : consumos) {
			if(consumoModel.getDeleted() == null) {
				consumos2.add(consumoModel);
			}
		}
		List<ConsumoModel> listaDeConsumos = consumos2.stream().map(this::toDto).collect(Collectors.toList());
		
		if(listaDeConsumos == null) {
			throw new ServiceException("Não existe consumos com esse combustivel");
		}
			
		return listaDeConsumos;
	}

	@Override
	public Consumo findByNomeCondutor(String nome) {
		Condutor condut = condutorRepository.findByNome(nome);
		Consumo resp = consumoRepository.findByCondutor(condut);

		return resp;
	}


	public ConsumoModel toDto(Consumo entity) {
        ConsumoModel dto = new ConsumoModel();
        dto.setIdConsumo(entity.getIdConsumo());
        dto.setCondutor(entity.getCondutor().getNome());
        dto.setVeiculo(entity.getVeiculo().getModelo());
        dto.setCombustivel(entity.getCombustivel().getNome());
        dto.setLitros(entity.getLitros());
        dto.setValor(entity.getValor());
        dto.setNumeroDaNotaFiscal(entity.getNumNotaFiscal());
        dto.setDataRegistroDaNota(entity.getDataRegistro());
        dto.setDataDeRegistro(entity.getDataDeCriacao());
        return dto;
    }
}
