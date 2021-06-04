package br.com.controlefrota.service;

import java.util.List;

import br.com.controlefrota.domain.model.ConsumoModel;
import br.com.controlefrota.model.Consumo;

public interface CadastroDeConsumo {

	public void criar(Consumo consumo);
	
	public void deletar(long id);
	
	public List<Consumo> findAll();
	
	public List<ConsumoModel> findbyCombustivel(String nome);

	public Consumo findByNomeCondutor(String nome);
}
