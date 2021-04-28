package br.com.controlefrota.service;

import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
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
		if(1==1) {
			 throw new ServiceException("Deu ruim! Veiculo ocupado");
		}
		trabalho.setCondutor(condutor);
		trabalho.setVeiculo(veiculo);
		trabalho.setDataInicioVigencia(LocalDate.now());
		veiculo.setStatus("Ocupado");
		
		return trabalhoRepository.save(trabalho);
	}
	
}
