package br.com.controlefrota.service;

import java.time.LocalDate;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlefrota.model.CondutorModel;
import br.com.controlefrota.model.TrabalhoModel;
import br.com.controlefrota.model.VeiculoModel;
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
	
	public TrabalhoModel  criar(TrabalhoModel trabalho) {
		CondutorModel condutor = condutorRepository.findByCNH(trabalho.getCondutor().getCNH());
		VeiculoModel veiculo = veiculoRepository.findByPlaca(trabalho.getVeiculo().getPlaca());
		
		if(veiculo == null) {
			throw new ServiceException("Veículo não encontrado!");
		}
		if(condutor == null) {
			throw new ServiceException("Condutor não encontrado!");
		}
		
		if(condutor.getStatus().equals("Em trabalho") || veiculo.getStatus().equals("Ocupado")) {
			if(condutor.getStatus().equals("Em trabalho")) {
				throw new ServiceException("Condutor em trabalho ativo");
			}else {
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
	public TrabalhoModel findById(long id) {
		TrabalhoModel trabalho = trabalhoRepository.findById(id);
		
		if(trabalho == null) {
			throw new ServiceException("Trabalho não encontrado.");
		}
		return trabalho;
	}
	
	public void encerrarTrabalho(long idTrabalho, String KmFinal) {
		TrabalhoModel trabalho = trabalhoRepository.findById(idTrabalho);
		CondutorModel condutor = condutorRepository.findByCNH(trabalho.getCondutor().getCNH());
		VeiculoModel veiculo = veiculoRepository.findByPlaca(trabalho.getVeiculo().getPlaca());
		
		if(trabalho.getStatusTrabalho().equals("Encerrado")) {
			throw new ServiceException("Trabalho já foi encerrado!");
		}
		if(trabalho == null) {
			
			throw new ServiceException("Trabalho não encontrado");
		}
		if(condutor == null) {
			
			throw new ServiceException("Trabalho não encontrado");
		}
		if(veiculo == null) {
			
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
	
}
