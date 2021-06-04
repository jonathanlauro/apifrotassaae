package br.com.controlefrota.service;

import java.util.List;

import br.com.controlefrota.model.Veiculo;
import org.hibernate.service.spi.ServiceException;

public interface CadastroDeVeiculo {

	public Veiculo criar(Veiculo veiculo) throws ServiceException;
	
	public void deletar(long id);
	
	public List<Veiculo> findAll();
	
	public Veiculo findById(long id);
	
	public Veiculo findByPlaca(String placa);
	
	public Veiculo findByRenavam(String renavam);
}
