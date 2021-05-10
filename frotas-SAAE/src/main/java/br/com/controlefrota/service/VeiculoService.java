package br.com.controlefrota.service;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Empresa;
import br.com.controlefrota.model.Veiculo;
import br.com.controlefrota.repository.EmpresaRepository;
import br.com.controlefrota.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	VeiculoRepository veiculoRepository;

	public Veiculo criar(Veiculo veiculo) throws Exception {
		Veiculo v = veiculoRepository.findByPlaca(veiculo.getPlaca());
		if (v.getStatus().equals("Ocupado")) {
			throw new ServiceException("Veículo ja cadastrado e em trabalho.");
		}
		
		if(v !=  null && v.getPlaca().equals(veiculo.getPlaca())) {
			veiculo.setIdVeiculo(v.getIdVeiculo());
			veiculo.setStatus("Disponivel");
			veiculo.setDeleted(false);
			veiculo.setDataCriacao(v.getDataCriacao());
			veiculo.setDataInicioVigencia(LocalDate.now());
			
			return veiculoRepository.save(veiculo);
		}else {
			
			Empresa empresa = empresaRepository.findById(veiculo.getEmpresa().getId())
					.orElseThrow(() -> new Exception("Empresa nao encontrado"));
			veiculo.setEmpresa(empresa);
			veiculo.setStatus("Disponivel");
			veiculo.setDeleted(false);
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

	public void deletar(long id) {
		Veiculo veiculo = veiculoRepository.findById(id);

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado.");
		}
		if (veiculo.getStatus().equals("Ocupado")) {
			throw new ServiceException("Veículo em trabalho.");
		}
		veiculo.setDataFimVigencia(LocalDate.now());
		veiculo.setDeleted(true);
		veiculoRepository.save(veiculo);
	}
	public List<Veiculo> findAll(){
		return veiculoRepository.findByDeleted(false);
	}

	public Veiculo findById(long id) {
		Veiculo veiculo = veiculoRepository.findById(id);

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado.");
		}
		return veiculo;
	}

	public Veiculo findByPlaca(String placa) {
		Veiculo veiculo = veiculoRepository.findByPlaca(placa);

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado.");
		}
		return veiculo;
	}

	public Veiculo findByRenavam(String renavam) {
		Veiculo veiculo = veiculoRepository.findByRenavam(renavam);

		if (veiculo == null) {
			throw new ServiceException("Veículo não encontrado.");
		}
		return veiculo;
	}

}
