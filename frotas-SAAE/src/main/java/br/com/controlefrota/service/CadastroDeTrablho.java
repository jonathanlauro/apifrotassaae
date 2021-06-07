package br.com.controlefrota.service;

import java.util.List;

import br.com.controlefrota.domain.model.TrabalhoModel;
import br.com.controlefrota.model.Trabalho;

public interface CadastroDeTrablho {

	public Trabalho  criar(Trabalho trabalho);
	
	public void deletar(long id);
	
	public Trabalho findById(long id);
	
	public List<TrabalhoModel> findAll();
	
	public void encerrarTrabalho(long idTrabalho, String kmFinal);
}
