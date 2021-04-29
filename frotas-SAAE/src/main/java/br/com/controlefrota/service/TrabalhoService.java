package br.com.controlefrota.service;

import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.Condutor;
import br.com.controlefrota.model.Trabalho;
import br.com.controlefrota.model.Veiculo;
import br.com.controlefrota.repository.CondutorRepository;
import br.com.controlefrota.repository.TrabalhoRepository;
import br.com.controlefrota.repository.VeiculoRepository;

@Service
public class TrabalhoService {

	
	@Autowired
	TrabalhoRepository trabalhoRepository;
	@Autowired
	CondutorRepository condutorRepository;
	@Autowired
	VeiculoRepository veiculoRepository;
	
	public Trabalho  criar(Trabalho trabalho) {
		Condutor condutor = condutorRepository.findByCNH(trabalho.getCondutor().getCNH());
		Veiculo veiculo = veiculoRepository.findByPlaca(trabalho.getVeiculo().getPlaca());
		
		Trabalho validaCondutor = trabalhoRepository.findByCondutor(condutor);
		if(veiculo == null) {
			throw new ServiceException("Veículo não encontrado!");
		}
		if(condutor == null) {
			throw new ServiceException("Condutor não encontrado!");
		}
		
		if(validaCondutor != null || veiculo.getStatus().equals("Ocupado")) {
			if(validaCondutor != null) {
				throw new ServiceException("Condutor em trabalho ativo");
			}else {
				throw new ServiceException("Veículo em trabalho ativo");
			}
			
		}
		trabalho.setCondutor(condutor);
		trabalho.setVeiculo(veiculo);
		trabalho.setDataInicioVigencia(LocalDate.now());
		veiculo.setStatus("Ocupado");
		
		return trabalhoRepository.save(trabalho);
	}
	
}
