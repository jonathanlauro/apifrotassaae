package br.com.controlefrota.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.controlefrota.domain.model.VeiculoModel;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Empresa;
import br.com.controlefrota.model.Veiculo;
import br.com.controlefrota.repository.EmpresaRepository;
import br.com.controlefrota.repository.VeiculoRepository;
import br.com.controlefrota.service.CadastroDeVeiculo;

@Service
public class VeiculoServiceEJB implements CadastroDeVeiculo{

	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	VeiculoRepository veiculoRepository;

	@Override
	public Veiculo criar(Veiculo veiculo) throws ServiceException {
		Veiculo v = veiculoRepository.findByPlaca(veiculo.getPlaca());
		if (v != null && v.getDeleted() == null) {
			throw new ServiceException("Veículo ja cadastrado.");
		}
		
		if(v !=  null && v.getPlaca().equals(veiculo.getPlaca())) {
			veiculo.setIdVeiculo(v.getIdVeiculo());
			veiculo.setStatus("Disponivel");
			veiculo.setDataCriacao(v.getDataCriacao());
			veiculo.setDataInicioVigencia(LocalDate.now());
			
			return veiculoRepository.save(veiculo);
		}else {
			
			Empresa empresa = empresaRepository.findById(veiculo.getEmpresa().getId())
					.orElseThrow(() -> new ServiceException("Empresa nao encontrado"));
			veiculo.setEmpresa(empresa);
			veiculo.setStatus("Disponivel");
			veiculo.setDataCriacao(LocalDate.now());
			veiculo.setDataInicioVigencia(LocalDate.now());
			
			
			if (veiculo.getRenavam().equals("000000000") || veiculo.getRenavam().equals("111111111")
					|| veiculo.getRenavam().equals("222222222") || veiculo.getRenavam().equals("333333333")
					|| veiculo.getRenavam().equals("444444444") || veiculo.getRenavam().equals("555555555")
					|| veiculo.getRenavam().equals("666666666") || veiculo.getRenavam().equals("777777777")
					|| veiculo.getRenavam().equals("888888888") || veiculo.getRenavam().equals("999999999")
					|| veiculo.getRenavam().length() != 9) {
				
				throw new ServiceException("Renavam inválido");
			}
			
			return veiculoRepository.save(veiculo);
		}
		
	}

	@Override
	public void deletar(long id) {
		Veiculo veiculo = veiculoRepository.findById(id);

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado.");
		}
		if (veiculo.getStatus().equals("Ocupado")) {
			throw new ServiceException("Veículo em trabalho.");
		}
		veiculo.setDataFimVigencia(LocalDate.now());
		veiculo.setDeleted(LocalDate.now());
		veiculoRepository.save(veiculo);
	}
	
	@Override
	public List<VeiculoModel> findAll(){
		return veiculoRepository.findByDeleted(null).stream().map(this::toDto).collect(Collectors.toList());
	}

	@Override
	public Veiculo findById(long id) {
		Veiculo veiculo = veiculoRepository.findById(id);

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado.");
		}
		return veiculo;
	}

	@Override
	public Veiculo findByPlaca(String placa) {
		Veiculo veiculo = veiculoRepository.findByPlaca(placa);

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado.");
		}
		return veiculo;
	}

	@Override
	public Veiculo findByRenavam(String renavam) {
		Veiculo veiculo = veiculoRepository.findByRenavam(renavam);

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado.");
		}
		return veiculo;
	}
	public VeiculoModel toDto(Veiculo entity) {
		VeiculoModel dto = new VeiculoModel();
		dto.setId(entity.getIdVeiculo());
		dto.setModelo(entity.getModelo());
		dto.setApelido(entity.getApelido());
		dto.setPlaca(entity.getPlaca());
		dto.setRenavam(entity.getRenavam());
		dto.setStatus(entity.getStatus());
		dto.setEmpresa(entity.getEmpresa().getNome());
		return dto;
	}

}
