package br.com.controlefrota.service;

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
		Empresa empresa = empresaRepository.findById(veiculo.getEmpresa().getId())
		.orElseThrow(() -> new Exception("Cliente nao encontrado"));
		veiculo.setEmpresa(empresa);
		
		return veiculoRepository.save(veiculo);
		}
}

